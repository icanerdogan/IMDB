package com.icanerdogan.imdb.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.icanerdogan.imdb.R
import com.icanerdogan.imdb.databinding.ActivityMovieBinding
import com.icanerdogan.imdb.presentation.dependencyinjection.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var adapter: MovieAdapter
    private lateinit var binding : ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerViewMovie.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerViewMovie.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.progressBarMovie.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer{
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarMovie.visibility = View.GONE
            }else{
                binding.progressBarMovie.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Avaliable!", Toast.LENGTH_LONG).show()
            }
        })
    }

    // UPDATE BUTTON CLICK
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun updateMovies(){
        binding.progressBarMovie.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this,  Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarMovie.visibility = View.GONE
            }else{
                binding.progressBarMovie.visibility = View.GONE
            }
        })
    }
}