package com.icanerdogan.imdb.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icanerdogan.imdb.R
import com.icanerdogan.imdb.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}