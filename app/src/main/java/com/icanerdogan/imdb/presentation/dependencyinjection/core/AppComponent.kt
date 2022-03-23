package com.icanerdogan.imdb.presentation.dependencyinjection.core

import com.icanerdogan.imdb.presentation.dependencyinjection.artist.ArtistSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.movie.MovieSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

fun movieSubComponent(): MovieSubComponent.Factory
fun tvShowSubComponent(): TvShowSubComponent.Factory
fun artistSubComponent(): ArtistSubComponent.Factory

}