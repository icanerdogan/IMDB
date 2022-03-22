package com.icanerdogan.imdb.data.API

import com.icanerdogan.imdb.data.model.artist.ArtistList
import com.icanerdogan.imdb.data.model.movie.MovieList
import com.icanerdogan.imdb.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET

interface TMDBService {

    @GET("movie/popular?api_key=YOUR_API_KEY&language=en-US&page=1")
    suspend fun getPopularMovies(): Response<MovieList>

    @GET("tv/popular?api_key=YOUR_API_KEY&language=en-US&page=1")
    suspend fun getPopularTVShows(): Response<TVShowList>

    @GET("person/popular?api_key=YOUR_API_KEY&language=en-US&page=1")
    suspend fun getPopularArtists(): Response<ArtistList>

}