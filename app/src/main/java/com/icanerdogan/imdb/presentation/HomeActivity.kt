package com.icanerdogan.imdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icanerdogan.imdb.R
import com.icanerdogan.imdb.databinding.ActivityMainBinding
import com.icanerdogan.imdb.databinding.ActivityTvshowBinding
import com.icanerdogan.imdb.presentation.artist.ArtistActivity
import com.icanerdogan.imdb.presentation.movie.MovieActivity
import com.icanerdogan.imdb.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMovie.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.buttonTVShow.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }
        binding.buttonArtist.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}