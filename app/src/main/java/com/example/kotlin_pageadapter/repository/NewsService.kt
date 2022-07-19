package com.example.kotlin_pageadapter

import com.example.kotlin_pageadapter.data.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsService {

     @GET("everything")
     suspend fun getNews(@Query("page")  page : Int ,@Query("pageSize") pageSize : Int  ,
                         @Query("apiKey") apiKey : String,
                         @Query("domains") domain: String
                        ):Response<Model>


}