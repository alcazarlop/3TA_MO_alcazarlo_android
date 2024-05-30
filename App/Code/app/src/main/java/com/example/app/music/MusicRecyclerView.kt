package com.example.app.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.R

class MusicRecyclerView(private val music: List<Music>, private  val listener: MusicListener) : RecyclerView.Adapter<MusicRecyclerView.MusicHolder>() {

    class MusicHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(music: Music, listener: MusicListener) {
            view.findViewById<TextView>(R.id.song).text = music.name
            val image = view.findViewById<ImageView>(R.id.image)
            if(music.imageURLPath.isNullOrEmpty()) {
                image.setImageResource(R.drawable.placeholder)
            }
            else {
                Glide.with(view.context)
                    .load(music.imageURLPath)
                    .error(R.drawable.placeholder)
                    .into(image)
            }
            view.setOnClickListener { listener.onMusicSelected(music) }
        }
    }

    override fun getItemCount() = music.size

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.bind(music[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MusicHolder(inflater.inflate(R.layout.music_item, parent, false))
    }

}