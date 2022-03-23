package com.icanerdogan.imdb.presentation.dependencyinjection.artist

import com.icanerdogan.imdb.domain.usecase.GetArtistUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateArtistUseCase
import com.icanerdogan.imdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }

}