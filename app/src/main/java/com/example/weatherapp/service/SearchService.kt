package com.example.weatherapp.service

import com.example.weatherapp.model.SearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.weatherapi.com/v1/search.json

interface SearchService {

    @GET("geo/1.0/direct")
    fun getLocation(
        @Query("q") query: String,
        @Query("appid") apiKey: String
    ): Call<List<SearchModel>>
}