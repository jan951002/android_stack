package com.servinf.androidstack.base

import android.app.Application
import com.servinf.androidstack.di.apiModule
import com.servinf.androidstack.di.repositoryModule
import com.servinf.androidstack.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 * @author Jaime Trujillo
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* Adding Koin modules to our application */
        startKoin {
            androidContext(this@BaseApplication)
            modules(apiModule, repositoryModule, viewModelModule)
        }
    }
}