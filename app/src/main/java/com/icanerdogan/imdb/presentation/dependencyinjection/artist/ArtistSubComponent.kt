package com.icanerdogan.imdb.presentation.dependencyinjection.artist

import com.icanerdogan.imdb.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }

}

