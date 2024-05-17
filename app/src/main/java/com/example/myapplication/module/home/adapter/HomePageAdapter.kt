package com.example.myapplication.module.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.module.data.CartDto

class HomePageAdapter : RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder>() {
    private val items: MutableList<CartDto> = mutableListOf()
    private  lateinit var inflater: LayoutInflater
    private lateinit var context: Context


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        return HomePageViewHolder(FragmentHomeBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<CartDto>) {
        items.clear()
        item.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }


    inner class HomePageViewHolder(binding: FragmentHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartDto) {

        }
    }
}