package com.example.app.retrofit

import com.example.app.music.Music
import retrofit2.http.GET

interface ApiService {
    @GET("/songs")
    suspend fun getSongs(): List<Music>
}