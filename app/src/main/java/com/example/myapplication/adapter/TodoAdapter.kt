package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.database.Tododb
import com.example.myapplication.databinding.TodoRecycleviewBinding
import com.example.myapplication.model.Todo
import com.example.myapplication.ripository.TodoRipository

class TodoAdapter(private  val  todos : List<Todo> , private  val clickListner  : (Todo)  ->  Unit) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner  class  TodoViewHolder(val  binding: TodoRecycleviewBinding):RecyclerView.ViewHolder(binding.root)
        private  val diff =AsyncListDiffer(this,Diffcallback)











    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return  TodoViewHolder(TodoRecycleviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            var  item = todos[position]
            TextView.text = item.todo
            date.text = item.date.toString()

        }
holder.binding.materialButton.setOnClickListener {
      clickListner(todos[position])
}
    }

    override fun getItemCount(): Int {
        return  todos.size
    }



}

