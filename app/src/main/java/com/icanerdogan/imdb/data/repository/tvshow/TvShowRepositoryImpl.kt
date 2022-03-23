package com.anushka.tmdbclient.data.repository.tvshow

import android.util.Log
import com.icanerdogan.imdb.data.model.tvshow.TVShow
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.icanerdogan.imdb.domain.repository.TVShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TVShowRepository {

    override suspend fun getTVShows(): List<TVShow> {
       return getTvShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow> {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TVShow>{
        lateinit var tvShowsList: List<TVShow>
        try {
           tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache():List<TVShow>{
        lateinit var tvShowsList: List<TVShow>
        try {
            tvShowsList =tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }
}