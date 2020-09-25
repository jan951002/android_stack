package com.servinf.androidstack.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.servinf.androidstack.R

/**
 * Dashboard view model class
 * @author Jaime Trujillo
 */
class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = application.getString(R.string.text_dashboard)
    }
    val text: LiveData<String> = _text
}