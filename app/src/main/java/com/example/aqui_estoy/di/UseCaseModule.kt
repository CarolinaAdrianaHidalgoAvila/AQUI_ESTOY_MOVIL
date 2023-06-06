package com.example.aqui_estoy.di

import com.example.data.LostPublicationRepository
import com.example.data.UserRepository
import com.example.usercase.GetAllLostPublications
import com.example.usercase.GetUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetAllLostPublicationsUseCase(
        lostPubsRepository: LostPublicationRepository
    )   = GetAllLostPublications(lostPubsRepository)

    @Provides
    fun provideGetUserUseCase(
        userRepository: UserRepository
    ) = GetUser(userRepository)
}