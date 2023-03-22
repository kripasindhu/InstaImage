package com.app.instaimage.di

import com.app.instaimage.repository.SearchImagesRepository
import com.app.instaimage.usecases.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideLogInUseCase(searchImagesRepository: SearchImagesRepository) =
        SearchUseCase(searchImagesRepository)
}