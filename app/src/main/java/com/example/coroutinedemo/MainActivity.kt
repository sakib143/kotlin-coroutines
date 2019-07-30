package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val alStudent : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            loadArray()
        }

        GlobalScope.launch(Dispatchers.Main) {
            val tempList : List<String> = async(Dispatchers.IO) {
                getList()
            }.await()
            Log.e("==> ","New Array list size "+ tempList.size)
        }
    }

    suspend fun loadArray(){
        alStudent.add("First")
        alStudent.add("Second")
        alStudent.add("Third")
        alStudent.add("Four")
        Log.e("==> ","Main Array list size  "+ alStudent.size)
    }

    fun getList():ArrayList<String>{
        return alStudent
    }
}
