package com.icanerdogan.imdb.data.repository.tvshow.datasourceImpl

import com.icanerdogan.imdb.data.API.TMDBService
import com.icanerdogan.imdb.data.model.tvshow.TVShowList
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
): TvShowRemoteDatasource {
    override suspend fun getTvShows()
            : Response<TVShowList> = tmdbService.getPopularTVShows()

}

