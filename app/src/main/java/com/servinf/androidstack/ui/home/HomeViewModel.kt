package com.servinf.androidstack.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.servinf.androidstack.data.api.UseCaseResult
import com.servinf.androidstack.data.model.Dog
import com.servinf.androidstack.data.repository.DogRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Home view model class
 * @author Jaime Trujillo
 */
class HomeViewModel(application: Application, private val dogRepository: DogRepository) :
    AndroidViewModel(application), CoroutineScope {

    // Coroutine's background job
    private val job = Job()

    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading
    private val _dogs = MutableLiveData<ArrayList<Dog>>()
    val dogs: LiveData<ArrayList<Dog>>
        get() = _dogs
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        getDogs()
    }

    private fun getDogs() {
        _loading.value = true
        launch {
            val result = withContext(Dispatchers.IO) { dogRepository.getDogs() }
            _loading.value = false
            when (result) {
                is UseCaseResult.Success -> _dogs.value = result.data
                is UseCaseResult.Error -> _error.value = result.exception.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Clear our job when the linked activity is destroyed to avoid memory leaks
        job.cancel()
    }
}