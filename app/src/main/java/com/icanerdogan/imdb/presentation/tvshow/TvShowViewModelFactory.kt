package com.icanerdogan.imdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.icanerdogan.imdb.domain.usecase.GetTVShowsUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateTVShowsUseCase

class TvShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}