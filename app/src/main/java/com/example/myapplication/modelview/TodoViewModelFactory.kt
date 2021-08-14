package com.example.myapplication.modelview

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ripository.TodoRipository

class TodoViewModelFactory(private  val repository : TodoRipository ,val  context: Context) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
            return  TodoViewModel(repository,context) as T

        }
        throw  IllegalArgumentException("Unknown View Model  class")
    }

}