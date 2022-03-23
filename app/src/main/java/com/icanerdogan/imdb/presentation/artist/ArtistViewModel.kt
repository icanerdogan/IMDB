package com.icanerdogan.imdb.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.icanerdogan.imdb.data.model.artist.Artist
import com.icanerdogan.imdb.domain.usecase.GetArtistUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateArtistUseCase


class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() : LiveData<List<Artist>?> = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() : LiveData<List<Artist>?> = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }

}