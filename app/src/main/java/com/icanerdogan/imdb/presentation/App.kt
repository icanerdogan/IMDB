package com.icanerdogan.imdb.presentation

import android.app.Application
import com.icanerdogan.imdb.presentation.dependencyinjection.Injector
import com.icanerdogan.imdb.presentation.dependencyinjection.artist.ArtistSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.core.*
import com.icanerdogan.imdb.presentation.dependencyinjection.movie.MovieSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.tvshow.TvShowSubComponent


class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteModule(RemoteModule())
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}