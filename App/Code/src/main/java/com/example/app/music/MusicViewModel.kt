package com.example.app.music

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.retrofit.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MusicViewModel : ViewModel() {
    private val musicList = MutableLiveData<List<Music>>()
    val music: LiveData<List<Music>> = musicList

    fun showSong(){
        viewModelScope.launch {
            try {
                val songs = RetrofitClient.service.getSongs()
                musicList.value = songs
            } catch (e: Exception) {
                Log.d("Error", "Error loading song: ${e.message}")
                Log.d("JSON", "Error loading song: ${e.message}")
            }
        }
    }
}