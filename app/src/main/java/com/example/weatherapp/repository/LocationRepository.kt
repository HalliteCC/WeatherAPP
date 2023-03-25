package com.example.weatherapp.repository


import android.content.Context

import com.example.weatherapp.R
import com.example.weatherapp.constant.WeatherConstant
import com.example.weatherapp.listener.APIListener

import com.example.weatherapp.model.LocationModel
import com.example.weatherapp.repository.retrofit.SearchRetrofit
import com.example.weatherapp.service.SearchService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository(context: Context): BaseRepository(context) {


    private val remote = SearchRetrofit.getService(SearchService::class.java)

    //Using API to get location by typing the name of the city and country
    fun getLocation(location: String, listener: APIListener<List<LocationModel>>){
        if(!isConnectionAvaiable()){
            listener.onFaliure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
            }


        val call = remote.getLocation(location, WeatherConstant.KEY.apiKey)
        call.enqueue( object : Callback<List<LocationModel>>{
            override fun onResponse(call: Call<List<LocationModel>>, response: Response<List<LocationModel>>) {
                val s = ""
            }

            override fun onFailure(call: Call<List<LocationModel>>, t: Throwable) {
                val s = ""
            }
        })
    }
}





