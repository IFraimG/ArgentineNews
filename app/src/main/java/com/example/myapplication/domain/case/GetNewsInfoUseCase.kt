package com.example.myapplication.domain.case

import com.example.myapplication.data.dto.NewsDTO
import com.example.myapplication.data.dto.TranslateNewsDTO
import com.example.myapplication.domain.repository.NewsRepository
import com.example.myapplication.domain.repository.TranslateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetNewsInfoUseCase(
    private val newsRepository: NewsRepository,
    private val translateRepository: TranslateRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(): MutableList<NewsDTO> = withContext(defaultDispatcher) {
            val news = newsRepository.getLastNews()
            val result: MutableList<NewsDTO> = mutableListOf()

            if (news.body()?.news != null) {
                for (article in news.body()!!.news) {

                    val content: Response<TranslateNewsDTO>? = if (article.content != null) translateRepository.translateNews(text=article.content) else null
                    val description: Response<TranslateNewsDTO>? = if (article.description != null) translateRepository.translateNews(text=article.description) else null
                    val title: Response<TranslateNewsDTO> = translateRepository.translateNews(text=article.title)
                    val author: Response<TranslateNewsDTO>? = if (article.author != null) translateRepository.translateNews(text=article.author) else null

                    val newArticle = article.copy(title = article.title, content = article.content, description = article.description, author = article.author,
                        translatedAuthor = author?.body()?.translatedText, translatedContent = content?.body()?.translatedText, translatedTitle = title.body()?.translatedText,
                        translatedDescription = description?.body()?.translatedText)

                    result.add(newArticle)
                }
            }

            result
        }
}