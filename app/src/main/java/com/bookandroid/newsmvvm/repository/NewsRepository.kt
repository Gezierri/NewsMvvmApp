package com.bookandroid.newsmvvm.repository

import com.bookandroid.newsmvvm.api.ApiService
import com.bookandroid.newsmvvm.data.ArticlesDatabase
import com.bookandroid.newsmvvm.fragments.BreakingNewsFragment
import com.bookandroid.newsmvvm.model.Article
import com.bookandroid.newsmvvm.model.NewsResponse
import retrofit2.Response

class NewsRepository(val db: ArticlesDatabase) {

    suspend fun getBreakingNews(country: String, page: Int): Response<NewsResponse> {
        return ApiService.api.getBreakingNews(country, page)
    }

    suspend fun searchNews(query: String, page: Int): Response<NewsResponse>{
        return ApiService.api.searchNews(query, page)
    }

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun delete(article: Article) = db.getArticleDao().delete(article)
}