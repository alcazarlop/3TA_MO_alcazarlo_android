package com.example.app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.music.MusicListener
import com.example.app.music.MusicRecyclerView
import com.example.app.music.MusicViewModel

class MusicFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MusicViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MusicViewModel::class.java]
        recyclerView = view.findViewById<RecyclerView>(R.id.musicRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.music.observe(viewLifecycleOwner) {
            music -> recyclerView.adapter = MusicRecyclerView(music, activity as MusicListener)
        }
        viewModel.showSong()
    }
}