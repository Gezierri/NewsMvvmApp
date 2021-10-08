package com.bookandroid.newsmvvm.model

import com.bookandroid.newsmvvm.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)