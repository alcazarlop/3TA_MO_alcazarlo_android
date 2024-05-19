package com.example.app.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://alcazarlo.free.beeceptor.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val service: ApiService = retrofit.create(ApiService::class.java)
}