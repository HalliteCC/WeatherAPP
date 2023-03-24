package com.example.weatherapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.weatherapp.repository.SearchRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val searchRepository = SearchRepository(application.applicationContext)


    fun getLocation(){
        searchRepository.getLocation()
    }
}