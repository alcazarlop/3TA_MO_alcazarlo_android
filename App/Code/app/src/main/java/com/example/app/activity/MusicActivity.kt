package com.example.app.activity

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.app.R


class MusicActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music)

        val group = intent.getStringExtra("key_group")
        val music = intent.getStringExtra("key_song")
        val image = intent.getStringExtra("image_key")
        val songurl = intent.getStringExtra("key_song_url")

        val audioAttributes = android.media.AudioAttributes.Builder()
            .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
            .setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        val sharedPreferences = getSharedPreferences("MusicSharedPref", MODE_PRIVATE)
        val album = sharedPreferences.getString("key_album", "Default")

        this.title = music
        findViewById<TextView>(R.id.musicActivityID).text = group
        val imageView = findViewById<ImageView>(R.id.musicImage)

        if(image.isNullOrEmpty()){
            imageView.setImageResource(R.drawable.placeholder)
        }
        else {
            Glide.with(this)
                .load(image)
                .error(R.drawable.placeholder)
                .into(imageView)
        }

        val backButton = findViewById<Button>(R.id.backButton).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val play = findViewById<Button>(R.id.playButton)

        mp = MediaPlayer().apply {
            setAudioAttributes(audioAttributes)
            setDataSource(songurl)
            prepareAsync()
            setOnPreparedListener {
                play.text = "Pause"
            }
            setOnCompletionListener {
                play.text = "Play"
            }
        }
        /*
       play.setOnClickListener{
            if(mp.isPlaying) {
                mp.stop()
                mp.reset()
                mp.release()
                Toast.makeText(this, "Pausing song", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
            }
        }
        */

    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }

    fun onPrepared(player: MediaPlayer) {
        player.start()
    }
}






