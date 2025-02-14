package com.example.androidfundamentals

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Collections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val list = listOf(5,3,6,7,9,1)
        sortList(list)
        Log.d("MainActivity", "Hello, this is our first log message")
        println(list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun sortList(list: List<Int>) {
        for (i in 0..list.size - 1) {
            for (j in 0..list.size - 2) {
                if (list[j] > list[j + 1]) {
                    Collections.swap(list, j, j + 1)
                }
            }
        }
    }


}