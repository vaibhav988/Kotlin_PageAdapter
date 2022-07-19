package com.example.kotlin_listadapter.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlin_listadapter.NewsPageAdapter
import com.example.kotlin_listadapter.databinding.ActivityMainBinding
import com.example.kotlin_listadapter.viewmodel.NewsViewModel

import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding    //creating viewbinding varible to bind with the corresponding layout file
    lateinit var newsPageAdapter : NewsPageAdapter   // Paging Adapter
    val newsViewModel : NewsViewModel = NewsViewModel() // creating viewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initviews()

        newsViewModel.fetchNewsViaPaging().observe(this@MainActivity)
        {
            newsPageAdapter.submitData(lifecycle , it)
        }




    }

    fun initviews()
    {
        newsPageAdapter = NewsPageAdapter(applicationContext)
        binding.recycler.layoutManager = LinearLayoutManager(this) // applying linearlayout to recyclerview
        binding.recycler.adapter = newsPageAdapter // setting up the adapter

    }



}