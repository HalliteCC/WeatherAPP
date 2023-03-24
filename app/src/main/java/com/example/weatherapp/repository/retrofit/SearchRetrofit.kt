package com.example.weatherapp.repository.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchRetrofit {

    companion object{

        private lateinit var INSTANCE: Retrofit
        //private const val BASE_URL = "http://api.weatherapi.com/v1/"
        private const val BASE_URL = "http://api.openweathermap.org/"
        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()

            if(!Companion::INSTANCE.isInitialized) {
                synchronized(SearchRetrofit::class){
                    INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                }
            }
            return INSTANCE
        }
        fun <S> getService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }

    }
}