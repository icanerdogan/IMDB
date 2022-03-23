package com.icanerdogan.imdb.data.repository.tvshow.datasource


import com.icanerdogan.imdb.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TVShowList>
}