package com.vivek.movietrend.di

import com.vivek.movietrend.data.remote.MoviesRemoteDataSource
import com.vivek.movietrend.data.repository.MoviesRepository
import com.vivek.movietrend.data.repository.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(
        moviesRemoteDataSource: MoviesRemoteDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(moviesRemoteDataSource)
    }
}