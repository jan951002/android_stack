package com.servinf.androidstack.data.repository

import android.content.Context
import com.servinf.androidstack.data.api.UseCaseResult
import com.servinf.androidstack.data.api.WikiApiService
import com.servinf.androidstack.data.db.dao.DogDao
import com.servinf.androidstack.data.db.model.Dog
import com.servinf.androidstack.util.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Class that will allow us to perform operations with the dog model
 * @author Jaime Trujillo
 */
interface DogRepository {

    suspend fun getDogs(): UseCaseResult<List<Dog>>

    suspend fun createDog(name: String, years: String): UseCaseResult<Dog>
}

class DogRepositoryImpl(
    private val wikiApiService: WikiApiService,
    private val dogDao: DogDao,
    private val context: Context
) : DogRepository {

    override suspend fun getDogs(): UseCaseResult<List<Dog>> {
        return if (isOnline(context))
            try {
                val result = wikiApiService.getDogsAsync().await()
                UseCaseResult.Success(result)
            } catch (ex: Exception) {
                UseCaseResult.Error(ex)
            }
        else
            try {
                val result = getDogsFromCache()
                UseCaseResult.Success(result)
            } catch (ex: Exception) {
                UseCaseResult.Error(ex)
            }
    }

    private suspend fun getDogsFromCache(): List<Dog> {
        return withContext(Dispatchers.IO) { dogDao.findAll() }
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