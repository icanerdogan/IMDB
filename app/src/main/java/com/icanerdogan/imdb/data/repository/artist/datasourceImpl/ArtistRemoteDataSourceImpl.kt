package com.icanerdogan.imdb.data.repository.artist.datasourceImpl

import com.icanerdogan.imdb.data.API.TMDBService
import com.icanerdogan.imdb.data.model.artist.ArtistList
import com.icanerdogan.imdb.data.model.movie.MovieList
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists()

}