package com.icanerdogan.imdb.data.repository.movie

import android.util.Log
import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.data.model.movie.MovieList
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieCacheDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieLocalDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.icanerdogan.imdb.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository{


    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
            else{
                movieList = arrayListOf()
            }
        } catch (e: Exception){
            Log.i("TAG",e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception){
            Log.i("TAG",e.message.toString())
        }

        if (movieList.isNotEmpty()){
            return movieList
        }
        else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception){
            Log.i("TAG",e.message.toString())
        }

        if (movieList.isNotEmpty()){
            return movieList
        }
        else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}