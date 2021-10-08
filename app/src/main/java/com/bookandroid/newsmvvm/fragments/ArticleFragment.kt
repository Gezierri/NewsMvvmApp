package com.bookandroid.newsmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.bookandroid.newsmvvm.MainActivity
import com.bookandroid.newsmvvm.R
import com.bookandroid.newsmvvm.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment() {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val articles = args.article
        webView.apply {
            webViewClient = WebViewClient()
            articles.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener {
            viewModel.saveNews(articles)
            Snackbar.make(it, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}