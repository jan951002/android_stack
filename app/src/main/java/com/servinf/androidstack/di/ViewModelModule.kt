package com.servinf.androidstack.di

import com.servinf.androidstack.ui.dashboard.DashboardViewModel
import com.servinf.androidstack.ui.home.HomeViewModel
import com.servinf.androidstack.ui.notifications.NotificationsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

/* Dependency injection for View Models module */
val viewModelModule = module {
    viewModel { HomeViewModel(dogRepository = get()) }
    viewModel { DashboardViewModel() }
    viewModel { NotificationsViewModel() }
}