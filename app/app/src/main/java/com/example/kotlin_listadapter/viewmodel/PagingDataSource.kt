package com.example.kotlin_listadapter.viewmodel


import androidx.paging.PagingSource
import com.example.kotlin_listadapter.data.Articles
import com.example.kotlin_listadapter.repository.NewsRepository
import retrofit2.HttpException
import java.io.IOException

class PagingDataSource : PagingSource<Int , Articles>() {

 override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Articles> {

     val page = params.key ?: 1       // current page
     val response = NewsRepository.getNews(page , params.loadSize)  //fetching response for current page

     return try {
         LoadResult.Page(
             response?: emptyList(),
            if (page == 1) null else page - 1,
           if (response?.isEmpty() == true) null else page + 1
         )
     }
     catch (exception: IOException) {
         return LoadResult.Error(exception)
     } catch (exception: HttpException) {
         return LoadResult.Error(exception)
     }







 }
}