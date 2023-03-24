package com.example.weatherapp.repository

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import com.example.weatherapp.R
import com.example.weatherapp.constant.WeatherConstant
import com.example.weatherapp.listener.APIListener
import com.example.weatherapp.model.LocationModel
import com.example.weatherapp.repository.retrofit.SearchRetrofit
import com.example.weatherapp.service.SearchService
import com.google.android.gms.location.FusedLocationProviderClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository(context: Context): BaseRepository(context) {

    private lateinit var location: FusedLocationProviderClient
    private val remote = SearchRetrofit.getService(SearchService::class.java)

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

    @SuppressLint("MissingPermission")
    fun getLastLocation(){
        if(LocationEnable()){
            location.lastLocation.addOnCompleteListener {
                    task ->
                var location: Location?= task.result
                if(location == null){
                    newLocation()
                }else {
                    Log.i("Location", location.longitude.toString())
                }
            }
        }
    }

    private fun newLocation() {
        TODO("Not yet implemented")
    }

    private fun LocationEnable(): Boolean {
        TODO("Not yet implemented")
    }



}