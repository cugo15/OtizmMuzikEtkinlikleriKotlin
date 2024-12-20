package com.aecg.oyunvemuzikae.app

import com.aecg.oyunvemuzikae.core.mediaplayer.MediaPlayerManager
import com.aecg.oyunvemuzikae.core.mediaplayer.MediaPlayerManagerImpl
import com.aecg.oyunvemuzikae.core.webview.WebViewManager
import com.aecg.oyunvemuzikae.core.webview.WebViewManagerImpl
import com.aecg.oyunvemuzikae.data.repository.MenuRepository
import com.aecg.oyunvemuzikae.data.repository.MenuRepositoryImpl
import com.aecg.oyunvemuzikae.data.repository.MuzikRepository
import com.aecg.oyunvemuzikae.data.repository.MuzikRepositoryImpl
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
    @Binds
    abstract fun bindMuzikRepository(muzikRepositoryImpl: MuzikRepositoryImpl): MuzikRepository
    @Binds
    abstract fun bindMediaPlayerManager(mediaPlayerManagerImpl: MediaPlayerManagerImpl): MediaPlayerManager
    @Binds
    abstract fun bindWebViewManager(webViewManagerImpl: WebViewManagerImpl): WebViewManager
}