package com.example.kotlin_pageadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlin_pageadapter.NewsPageAdapter

import com.example.kotlin_pageadapter.viewmodel.NewsViewModel
import com.example.kotlin_pageadapter.databinding.ActivityMainBinding

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