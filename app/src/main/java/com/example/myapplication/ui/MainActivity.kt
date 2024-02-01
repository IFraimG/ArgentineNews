package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.example.myapplication.data.remote.NewsListDTO
import com.example.myapplication.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadNews()
    }

    private fun loadNews() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val repository = NewsRepository()
                val res: Response<NewsListDTO> = withContext(Dispatchers.IO) {
                    repository.getLastNews()
                }
                if (res.isSuccessful) {
                    Log.d("msg", res.body()?.news.toString())
                }

            } catch (err: HttpException) {
                Log.e("err", err.message())
            }
        }
    }
}