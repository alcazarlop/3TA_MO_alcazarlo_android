package com.example.app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.music.Music
import com.example.app.music.MusicListener
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : AppCompatActivity(), MusicListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        FirebaseCrashlytics.getInstance()

        val button = findViewById<Button>(R.id.crash).setOnClickListener {
            throw RuntimeException()
        }
    }

    override fun onMusicSelected(music: Music) {
        // val sharedPreferences = getSharedPreferences("MusicSharedPref", MODE_PRIVATE)

        val intent = Intent(this, MusicActivity::class.java).apply {
            putExtra("key_song", music.name)
            putExtra("key_group", music.group)
            putExtra("key_album", music.album)
            putExtra("key_image", music.imageURLPath)
            putExtra("key_song_url", music.songURL)
        }
        startActivity(intent)
    }
}