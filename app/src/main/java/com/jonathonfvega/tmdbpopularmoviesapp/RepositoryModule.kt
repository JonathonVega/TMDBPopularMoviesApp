package com.jonathonfvega.tmdbpopularmoviesapp

import com.jonathonfvega.tmdbpopularmoviesapp.repository.TMDBRepository
import com.jonathonfvega.tmdbpopularmoviesapp.repository.TMDBRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        tmdbRepositoryImpl: TMDBRepositoryImpl
    ): TMDBRepository
}