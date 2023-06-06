package com.example.aqui_estoy.di

import com.example.aqui_estoy.server.ConstantsRestApi
import com.example.aqui_estoy.server.IApiService
import com.example.aqui_estoy.server.RetrofitBuilder
import com.example.aqui_estoy.server.RemoteDataSource
import com.example.data.IRemoteDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): IApiService {
        return retrofit.create(IApiService::class.java)
    }

    @Provides
    fun provideRemoteDataSource(apiRest: RetrofitBuilder) : IRemoteDataSource = RemoteDataSource(apiRest)
}
