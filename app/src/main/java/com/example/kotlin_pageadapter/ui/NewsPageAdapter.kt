package com.example.kotlin_pageadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_pageadapter.data.Articles
import com.example.kotlin_pageadapter.databinding.NewsItemBinding

import com.example.kotlin_pageadapter.ui.NewsDetailActivity

class NewsPageAdapter(val context: Context) : PagingDataAdapter<Articles, NewsPageAdapter.ItemViewholder>(DiffCallback()) {

    lateinit var binding : NewsItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        binding  =  NewsItemBinding.inflate(LayoutInflater.from(context) , parent , false )
        return  ItemViewholder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener(
            {
                val intent = Intent( context ,  NewsDetailActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("article" ,getItem(position))
                context.startActivity(intent)
            }
        )
    }

    class ItemViewholder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

         fun bind(item: Articles){
             binding.newsTitle.text = item.title
         }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Articles>() {
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem.source?.id == newItem.source?.id
    }

    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem == newItem
    }
}
