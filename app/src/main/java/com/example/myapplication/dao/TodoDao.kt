package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.example.myapplication.model.Todo

@Dao
interface TodoDao {

     @Query("SELECT * FROM todo_table ORDER BY id")
           fun  getAllData() : LiveData<List<Todo>>

    @Insert(onConflict = 1)
    suspend fun  insertTodo(todo : Todo)

    @Delete
    suspend fun  deleteTodo(todo: Todo)

    @Query("DELETE FROM  TODO_TABLE ")
        suspend fun    deleteall()


}