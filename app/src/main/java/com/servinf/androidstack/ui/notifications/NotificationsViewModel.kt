package com.servinf.androidstack.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.servinf.androidstack.R

/**
 * Notifications view model class
 * @author Jaime Trujillo
 */
class NotificationsViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = application.getString(R.string.text_notifications)
    }
    val text: LiveData<String> = _text
}