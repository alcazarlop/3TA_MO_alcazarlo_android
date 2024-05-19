package com.example.app.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.R

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music)

        val group = intent.getStringExtra("Group Name")
        val music = intent.getStringExtra("Song Name")

        val sharedPreferences = getSharedPreferences("MusicSharedPref", MODE_PRIVATE)
        val album = sharedPreferences.getString("album_key", "Default")

        this.title = music
        findViewById<TextView>(R.id.musicActivityID).text = group
    }
}