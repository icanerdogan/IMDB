package com.icanerdogan.imdb.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.icanerdogan.imdb.data.model.tvshow.TVShow
import com.icanerdogan.imdb.domain.usecase.GetTVShowsUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateTVShowsUseCase

class TvShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel() {

 fun getTvShows()  : LiveData<List<TVShow>?> = liveData {
     val tvShowList = getTVShowsUseCase.execute()
     emit(tvShowList)
 }

 fun updateTvShows() : LiveData<List<TVShow>?> = liveData {
     val tvShowList = updateTVShowsUseCase.execute()
     emit(tvShowList)
 }
}
