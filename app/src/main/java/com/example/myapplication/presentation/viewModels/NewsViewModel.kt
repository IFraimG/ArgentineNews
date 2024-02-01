package com.example.myapplication.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.NewsListDTO
import com.example.myapplication.domain.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel (
    private val repository: NewsRepository
): ViewModel() {

    init {
        getNewsList()
    }

    fun getNewsList() = viewModelScope.launch {
//        repository.getLastNews().enqueue(object: Callback<NewsListDTO> {
//            override fun onResponse(call: Call<NewsListDTO>, response: Response<NewsListDTO>) {
//                if (response.isSuccessful) {
//                    Log.d("msg", response.body()?.news?.get(0)!!.content)
//                }
//            }
//
//            override fun onFailure(call: Call<NewsListDTO>, t: Throwable) {
//
//            }
//        })
    }
}