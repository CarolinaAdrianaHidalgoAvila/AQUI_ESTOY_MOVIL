package com.aquiestoy.aqui_estoy.di

import com.aquiestoy.data.LostPublicationRepository
import com.aquiestoy.data.UserRepository
import com.aquiestoy.usercase.GetAllLostPublications
import com.aquiestoy.usercase.GetUser
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