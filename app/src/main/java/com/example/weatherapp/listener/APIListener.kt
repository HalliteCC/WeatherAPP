package com.example.weatherapp.listener

interface APIListener<S> {
    fun onSuccess(result: S)
    fun onFaliure(message: String)
}