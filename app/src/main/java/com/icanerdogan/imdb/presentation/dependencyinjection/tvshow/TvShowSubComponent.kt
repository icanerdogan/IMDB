package com.icanerdogan.imdb.presentation.dependencyinjection.tvshow


import com.icanerdogan.imdb.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}

