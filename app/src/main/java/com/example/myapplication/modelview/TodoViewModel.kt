package com.example.myapplication.modelview

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.model.Todo
import com.example.myapplication.ripository.TodoRipository
import kotlinx.coroutines.launch
import java.util.*

class TodoViewModel( private  val   ripo : TodoRipository ,  val  context: Context) : ViewModel() , Observable{

     val todos = ripo.allTodos

     @Bindable
     var inputField   = MutableLiveData("")




     fun  save ()  {
          if(inputField.value!!.trim() != "") {
               insert(Todo(0,inputField.value!!.trim(), Date()))
          }


          inputField.value = ""
     }

     fun deleteall(){
          AlertDialog.Builder(context)
               .setTitle("Delete all")
               .setMessage("do you want to delete all notes ?")
               .setIcon(R.drawable.ic_deketall)
               .setPositiveButton("yes",{_,_ -> allremove()})
               .setNegativeButton("No",{_ , _ -> })
               .create().show()


     }


     //
     private fun  insert(todo: Todo){
          viewModelScope.launch {
               ripo.addtodos(todo)
          }
     }
     fun  delete(todo: Todo){
     viewModelScope.launch {
          ripo.deletetodo(todo)
     }
}

     fun  allremove(){
          viewModelScope.launch {
               ripo.removeall()
          }
     }
     override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
     }

     override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
     }


}