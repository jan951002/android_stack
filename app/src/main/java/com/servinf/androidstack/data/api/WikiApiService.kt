package com.servinf.androidstack.data.api

import com.servinf.androidstack.data.db.model.Dog
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * Wiki API service class with Retrofit
 * @author Jaime Trujillo
 */
interface WikiApiService {

    @GET("dog")
    fun getDogsAsync(): Deferred<List<Dog>>

    //POST with form request
    @FormUrlEncoded
    @POST("dog")
    fun createDogAsync(
        @Field("name") name: String, @Field("years") years: String
    ): Deferred<Dog>

    /*
    //POST with body request
    @POST("dog_body")
    fun createDodAsync(@Body dog: Dog): Deferred<Dog>
    */
}