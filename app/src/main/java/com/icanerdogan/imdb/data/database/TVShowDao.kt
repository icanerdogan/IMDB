package com.icanerdogan.imdb.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.icanerdogan.imdb.data.model.tvshow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvshows : List<TVShow>)

    @Query(value = "DELETE FROM popular_tvShows")
    suspend fun deleteAllTVShows()

    @Query(value = "SELECT * FROM popular_tvShows")
    suspend fun getTVShows(tvshows : List<TVShow>)
}