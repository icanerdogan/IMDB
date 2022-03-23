package com.icanerdogan.imdb.data.repository.tvshow.datasource

import com.icanerdogan.imdb.data.model.tvshow.TVShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TVShow>
    suspend fun saveTvShowsToCache(tvShows:List<TVShow>)

}