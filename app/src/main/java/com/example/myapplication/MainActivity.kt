package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.TodoAdapter
import com.example.myapplication.database.Tododb
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Todo
import com.example.myapplication.modelview.TodoViewModel
import com.example.myapplication.modelview.TodoViewModelFactory
import com.example.myapplication.ripository.TodoRipository

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    private  lateinit var  todoViewModel: TodoViewModel
    private  lateinit var  todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val  dao = Tododb.getInstance(application).dao
        val repository  = TodoRipository(dao)
        val factory = TodoViewModelFactory(repository , this)
        todoViewModel = ViewModelProvider(this,factory).get(TodoViewModel::class.java)
        binding.todoviewmodel =todoViewModel
        binding.lifecycleOwner = this




        setupRecyler()


    }






    private  fun  setupRecyler() {
         binding.rv.layoutManager = LinearLayoutManager(this)
        displaydata()

    }
    private  fun  displaydata(){
        todoViewModel.todos.observe(this, Observer {
            Log.i("mytag" , it.toString())
            binding.rv.adapter = TodoAdapter(it) { selectedIem: Todo -> clickeditem(selectedIem) }


        })
    }
    private  fun clickeditem (todo : Todo){
        AlertDialog.Builder(this)
            .setTitle("delete")
            .setMessage("do you want to delete this item")
            .setIcon(R.drawable.ic_deketall)
            .setPositiveButton("yes"){_ , _ ->todoViewModel.delete(todo)}
            .setNegativeButton("no"){_ , _ -> }
            .create().show()

    }

}