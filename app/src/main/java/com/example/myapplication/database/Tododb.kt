package com.example.myapplication.database

import android.content.Context
import androidx.room.*
import com.example.myapplication.converter.Converter
import com.example.myapplication.dao.TodoDao
import com.example.myapplication.model.Todo


@Database(entities = [Todo::class],version = 3 , exportSchema = false)
@TypeConverters(Converter::class)
abstract class Tododb : RoomDatabase() {

    abstract  val  dao : TodoDao

    companion object{

        @Volatile
        private  var INSTANCE  : Tododb? = null

        fun  getInstance(context : Context) : Tododb {
            synchronized(this){
               var instance  : Tododb? = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext , Tododb::class.java,"todo_db").fallbackToDestructiveMigration().build()
                }
                return  instance
            }
        }

    }

}