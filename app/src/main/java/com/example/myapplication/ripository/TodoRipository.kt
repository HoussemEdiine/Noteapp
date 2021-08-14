package com.example.myapplication.ripository

import androidx.lifecycle.LiveData
import com.example.myapplication.dao.TodoDao
import com.example.myapplication.model.Todo

//ripo
class TodoRipository(private  val  dao : TodoDao) {


    val allTodos : LiveData<List<Todo>> = dao.getAllData()

        suspend fun  addtodos(todo: Todo) {
            dao.insertTodo(todo)
        }
     suspend fun  deletetodo(todo: Todo ){
        dao.deleteTodo(todo)
    }

suspend    fun removeall(){
        dao.deleteall()
    }
}