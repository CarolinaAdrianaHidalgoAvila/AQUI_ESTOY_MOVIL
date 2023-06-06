package com.example.aqui_estoy.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class, DataModule::class, AppModule::class])
interface AppComponent {
}