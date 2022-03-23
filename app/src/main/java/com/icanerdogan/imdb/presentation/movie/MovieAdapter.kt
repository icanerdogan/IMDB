package com.icanerdogan.imdb.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.databinding.RowLayoutBinding

class MovieAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MyViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(movie : Movie){
        binding.rowLayoutTitleTextView.text = movie.title
        binding.rowLayoutDescriptionTextView.text = movie.overview

        val posterURL : String = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.rowLayoutImageView.context)
            .load(posterURL)
            .into(binding.rowLayoutImageView)
    }
}