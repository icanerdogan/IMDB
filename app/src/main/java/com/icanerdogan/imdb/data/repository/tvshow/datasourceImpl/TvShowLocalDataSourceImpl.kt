package com.icanerdogan.imdb.data.repository.tvshow.datasourceImpl

import com.icanerdogan.imdb.data.database.TVShowDao
import com.icanerdogan.imdb.data.model.tvshow.TVShow
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvDao: TVShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TVShow> {
       return tvDao.getTVShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           tvDao.deleteAllTVShows()
       }
    }
}