package com.vivek.movietrend.di

import com.vivek.movietrend.data.remote.MoviesRemoteDataSource
import com.vivek.movietrend.data.remote.MoviesRemoteDataSourceImpl
import com.vivek.movietrend.data.remote.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideMoviesRemoteDataSource(
        moviesService: MoviesService
    ): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(moviesService)
    }
}