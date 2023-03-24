package com.example.weatherapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.weatherapp.listener.APIListener
import com.example.weatherapp.model.LocationModel
import com.example.weatherapp.repository.LocationRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val searchRepository = LocationRepository(application.applicationContext)


    fun getLocation(location: String){
        searchRepository.getLocation(location, object : APIListener<List<LocationModel>>{
            override fun onSuccess(result: List<LocationModel>) {
                TODO("Not yet implemented")
            }

            override fun onFaliure(message: String) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getLastLocation(){
        searchRepository.getLastLocation()
    }
}