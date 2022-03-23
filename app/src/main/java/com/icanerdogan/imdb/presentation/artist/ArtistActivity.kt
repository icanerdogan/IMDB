package com.icanerdogan.imdb.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icanerdogan.imdb.R
import com.icanerdogan.imdb.databinding.ActivityArtistBinding
import com.icanerdogan.imdb.databinding.ActivityTvshowBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}