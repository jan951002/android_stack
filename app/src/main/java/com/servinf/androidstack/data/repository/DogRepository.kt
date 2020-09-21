package com.servinf.androidstack.data.repository

import com.servinf.androidstack.data.api.UseCaseResult
import com.servinf.androidstack.data.api.WikiApiService
import com.servinf.androidstack.data.model.Dog
import java.lang.Exception

/**
 * Class that will allow us to perform operations with the dog model
 * @author Jaime Trujillo
 */
interface DogRepository {

    suspend fun getDogs(): UseCaseResult<ArrayList<Dog>>

    suspend fun createDog(name: String, years: String): UseCaseResult<Dog>
}

class DogRepositoryImpl(private val wikiApiService: WikiApiService) : DogRepository {

    override suspend fun getDogs(): UseCaseResult<ArrayList<Dog>> {
        return try {
            val result = wikiApiService.getDogsAsync().await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

    override suspend fun createDog(name: String, years: String): UseCaseResult<Dog> {
        return try {
            val result = wikiApiService.createDogAsync(name, years).await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}