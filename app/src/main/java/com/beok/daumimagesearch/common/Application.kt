package com.beok.daumimagesearch.common

import android.app.Application
import com.beok.daumimagesearch.di.dataSourceModule
import com.beok.daumimagesearch.di.getRemoteServiceModule
import com.beok.daumimagesearch.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(
                listOf(
                    viewModelModule,
                    dataSourceModule,
                    getRemoteServiceModule("https://dapi.kakao.com")
                )
            )
        }

    }
}