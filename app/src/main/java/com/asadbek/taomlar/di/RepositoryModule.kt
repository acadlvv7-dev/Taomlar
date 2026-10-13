package com.asadbek.taomlar.di

import com.asadbek.taomlar.data.repository.TaomRepositoryImpl
import com.asadbek.taomlar.domain.repository.TaomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTaomRepository(
        impl: TaomRepositoryImpl
    ): TaomRepository
}