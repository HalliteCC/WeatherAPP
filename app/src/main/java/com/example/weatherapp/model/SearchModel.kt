package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

//data class Main(val lat: Double, val long: Double)
//data class GetCityModel(val name: String, val main: Main)
class SearchModel {

    @SerializedName("name")
    lateinit var cityName: String
    @SerializedName("lat")
    var lat: Double = 0.0
    @SerializedName("lon")
    var lon: Double = 0.0
    @SerializedName("country")
    lateinit var countryName: String
    @SerializedName("state")
    lateinit var stateName: String
}


/*
* [
    {
        "name": "São Carlos",
        "local_names": {
            "pt": "São Carlos"
        },
        "lat": -22.0180395,
        "lon": -47.891154,
        "country": "BR",
        "state": "São Paulo"
    }
]*/

