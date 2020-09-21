package com.servinf.androidstack.data.api

/**
 * This will be useful to get the data if the request was successful or get the exception if our request failed
 * @author Jaime Trujillo
 */
sealed class UseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class Error(val exception: Throwable) : UseCaseResult<Nothing>()
}