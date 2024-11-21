package com.aecg.oyunvemuzikae.app

import com.aecg.oyunvemuzikae.data.repository.MenuRepository
import com.aecg.oyunvemuzikae.data.repository.MenuRepositoryImpl
import com.aecg.oyunvemuzikae.data.repository.PianoRepository
import com.aecg.oyunvemuzikae.data.repository.PianoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMenuRepository(menuRepositoryImpl: MenuRepositoryImpl): MenuRepository
    @Binds
    abstract fun bindPianoRepository(pianoRepositoryImpl: PianoRepositoryImpl): PianoRepository
}