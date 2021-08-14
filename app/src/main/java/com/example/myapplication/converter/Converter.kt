package com.example.myapplication.converter

import androidx.room.TypeConverter
import java.util.*

class Converter {

    companion object{

         @TypeConverter
         @JvmStatic
         fun todate(value : Long): Date{
             val date = Date(value)
             return  date

         }

        @TypeConverter
        @JvmStatic
        fun  fromdate(date: Date): Long {
            return  date.time
        }
    }


}