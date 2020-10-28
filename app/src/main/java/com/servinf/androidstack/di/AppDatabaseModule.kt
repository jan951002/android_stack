package com.servinf.androidstack.di

import android.app.Application
import androidx.room.Room
import com.servinf.androidstack.data.db.AppDatabase
import com.servinf.androidstack.data.db.dao.DogDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module to configure room database dependency injection
 * @author Jaime Trujillo
 */
val appDatabaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "app-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDogDao(appDatabase: AppDatabase): DogDao = appDatabase.dogDao

    /* Define a Singleton instance for AppDatabase */
    single { provideDatabase(androidApplication()) }

    /* Define a Singleton instance for DogDao */
    single { provideDogDao(get()) }
}