package com.icanerdogan.imdb.presentation.dependencyinjection

import com.icanerdogan.imdb.presentation.dependencyinjection.artist.ArtistSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.movie.MovieSubComponent
import com.icanerdogan.imdb.presentation.dependencyinjection.tvshow.TvShowSubComponent

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
}