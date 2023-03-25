package com.example.weatherapp

import android.app.Application
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.listener.APIListener
import com.example.weatherapp.model.LocationModel
import com.example.weatherapp.repository.BaseRepository
import com.example.weatherapp.repository.LocationRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val baseRepository = BaseRepository(application.applicationContext)
    private val searchRepository = LocationRepository(application.applicationContext)


    val _locationLiveData = MutableLiveData<Location>()
    val locationLiveData: LiveData<Location>
    get() = _locationLiveData

    private val locationListener = object : LocationListener {

        override fun onLocationChanged(location: Location) {
            _locationLiveData.postValue(location)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: android.os.Bundle?) {}
    }
    val locationManager = application.getSystemService(LocationManager::class.java)
    init {
        getGPSLocation()
    }

    fun getGPSLocation() {
        if(baseRepository.checkPermission()){
            if (baseRepository.isLocationAvaiable() && baseRepository.isConnectionAvaiable()) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0F,
                    locationListener
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        locationManager.removeUpdates(locationListener)
    }

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




}