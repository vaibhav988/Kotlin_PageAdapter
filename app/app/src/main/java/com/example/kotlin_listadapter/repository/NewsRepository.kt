package com.example.kotlin_listadapter.repository

import android.util.Log
import com.example.kotlin_listadapter.data.Articles
import com.example.kotlin_listadapter.data.Model
import com.example.kotlin_listadapter.newsService
import retrofit2.Response
import kotlin.collections.ArrayList

class NewsRepository {


    companion object{

        suspend fun getNews( page : Int ,  pagesize : Int): List<Articles>?
        {
            val newsModel: Response<Model> =
                RetrofitService.getInstance().create(newsService :: class.java)
                    .getNews(page,pagesize, API.apiKey,
           "techcrunch.com" )

            return newsModel.body()?.articles
        }
    }

}