package com.aquiestoy.aqui_estoy.di


import com.aquiestoy.aqui_estoy.server.RemoteDataSource
import com.aquiestoy.data.LostPublicationRepository
import com.aquiestoy.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideLostPublicationsRepository(
        remoteDataSource: RemoteDataSource
    ) = LostPublicationRepository(remoteDataSource)

    @Provides
    fun provideUserRepository(
        remoteDataSource: RemoteDataSource
    ) = UserRepository(remoteDataSource)
}