package com.bookandroid.newsmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bookandroid.newsmvvm.repository.NewsRepository

class ViewModelFactory(
    val app: Application,
    private val newsRepository: NewsRepository
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }
}