package com.icanerdogan.imdb.data.repository.tvshow.datasource

import com.icanerdogan.imdb.data.model.tvshow.TVShow

interface TvShowLocalDataSource {
  suspend fun getTvShowsFromDB():List<TVShow>
  suspend fun saveTvShowsToDB(tvShows:List<TVShow>)
  suspend fun clearAll()
}