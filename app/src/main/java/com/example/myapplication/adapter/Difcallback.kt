package com.example.myapplication.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.model.Todo

object Diffcallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return  oldItem == newItem
    }
}