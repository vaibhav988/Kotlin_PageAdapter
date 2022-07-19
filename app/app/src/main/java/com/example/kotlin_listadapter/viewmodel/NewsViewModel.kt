package com.example.kotlin_listadapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.kotlin_listadapter.data.Articles

class NewsViewModel : ViewModel() {

    fun fetchNewsViaPaging() : LiveData<PagingData<Articles>> {
        return Pager(
            config = PagingConfig(10 , maxSize = 100),
            pagingSourceFactory = { PagingDataSource() }
        ).liveData.cachedIn(viewModelScope)
    }

}