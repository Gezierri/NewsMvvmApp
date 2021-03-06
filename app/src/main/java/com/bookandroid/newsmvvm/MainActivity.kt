package com.bookandroid.newsmvvm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bookandroid.newsmvvm.data.ArticlesDatabase
import com.bookandroid.newsmvvm.repository.NewsRepository
import com.bookandroid.newsmvvm.viewmodel.NewsViewModel
import com.bookandroid.newsmvvm.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticlesDatabase(this))
        val viewModelProviderFactory = ViewModelFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}