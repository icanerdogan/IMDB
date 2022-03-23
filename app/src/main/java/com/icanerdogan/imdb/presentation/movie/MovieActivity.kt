package com.icanerdogan.imdb.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icanerdogan.imdb.R
import com.icanerdogan.imdb.databinding.ActivityArtistBinding
import com.icanerdogan.imdb.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}