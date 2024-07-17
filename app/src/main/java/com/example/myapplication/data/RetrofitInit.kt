package com.example.myapplication.data

import com.example.myapplication.data.api.NewsAPI
import com.example.myapplication.data.api.TranslateAPI
import com.example.myapplication.domain.Configs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {
    companion object {
        private val newsRetrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(Configs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        private val translateRetrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(Configs.TRANSLATE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }


        val api: NewsAPI by lazy {
            newsRetrofit.create(NewsAPI::class.java)
        }

        val translateAPI: TranslateAPI by lazy {
            translateRetrofit.create(TranslateAPI::class.java)
        }
    }
}