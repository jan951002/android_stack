package com.servinf.androidstack.di

import com.servinf.androidstack.data.repository.DogRepository
import com.servinf.androidstack.data.repository.DogRepositoryImpl
import org.koin.dsl.module

/**
 * Module to configure repositories dependency injection
 * @author Jaime Trujillo
 */

/* Dependency injection for Repositories module */
val repositoryModule = module {

    /* Define a factory (create a new instance each time) for DogRepository */
    factory<DogRepository> { DogRepositoryImpl(wikiApiService = get()) }
}