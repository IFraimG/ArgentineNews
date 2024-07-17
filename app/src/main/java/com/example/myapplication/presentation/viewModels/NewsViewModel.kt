package com.example.myapplication.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.data.dto.NewsDTO
import com.example.myapplication.data.dto.NewsListDTO
import com.example.myapplication.domain.case.GetNewsInfoUseCase
import com.example.myapplication.domain.repository.NewsRepository
import com.example.myapplication.domain.repository.TranslateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response


class NewsViewModel (
    private val repository: NewsRepository,
    private val getNewsInfoUseCase: GetNewsInfoUseCase
): ViewModel() {
    private val _news = MutableStateFlow<List<NewsDTO>>(emptyList())
    val news: StateFlow<List<NewsDTO>> = _news.asStateFlow()

    init {
        loadNews()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
           initializer {
                val newsRepository = NewsRepository()
                val translateRepository = TranslateRepository()

                NewsViewModel(repository = newsRepository, getNewsInfoUseCase = GetNewsInfoUseCase(newsRepository = newsRepository,
                    translateRepository = translateRepository))
            }
        }
    }


    fun loadNews() = CoroutineScope(Dispatchers.Main).launch {
        try {
            val res: Response<NewsListDTO> = withContext(Dispatchers.IO) {
                repository.getLastNews()
            }
            if (res.isSuccessful) {
                _news.update { res.body()?.news ?: emptyList() }
                Log.d("msg", res.body()?.news.toString())
            }

        } catch (err: HttpException) {
            Log.e("err", err.message())
        }
    }

    fun translateNews() = CoroutineScope(Dispatchers.Main).launch {
        getNewsInfoUseCase()
    }
}