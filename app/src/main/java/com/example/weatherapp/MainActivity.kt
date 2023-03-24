package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.weatherapp.constant.WeatherConstant
import com.example.weatherapp.model.SearchModel
import com.example.weatherapp.repository.retrofit.SearchRetrofit
import com.example.weatherapp.service.SearchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer()
    }
    override fun onClick(v: View){
        if(v.id == R.id.edit_search){
            handleSearch()
        }
    }

    fun observer(){

    }

}