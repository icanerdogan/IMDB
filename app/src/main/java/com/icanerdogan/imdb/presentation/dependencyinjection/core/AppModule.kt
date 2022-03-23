package com.icanerdogan.imdb.presentation.dependencyinjection.core

import android.content.Context
import com.icanerdogan.imdb.presentation.dependencyinjection.artist.ArtistSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.movie.MovieSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}