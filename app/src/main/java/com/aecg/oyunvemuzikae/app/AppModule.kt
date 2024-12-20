package com.aecg.oyunvemuzikae.app

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }
    @Provides
    fun provideSoundPool(): SoundPool {
        return SoundPool.Builder()
            .setMaxStreams(10)
            .build()
    }
    @Singleton
    @Provides
    fun provideMediaPlayer(): MediaPlayer {
        return MediaPlayer()
    }

}
