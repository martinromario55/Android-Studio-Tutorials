package com.example.androidfundamentals

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        val btnApply = findViewById<Button>(R.id.btnApply)
//
//        btnApply.setOnClickListener {
//            val firstName = findViewById<TextView>(R.id.etFirstName).text.toString()
//            val lastName = findViewById<TextView>(R.id.etLastName).text.toString()
//            val birthDate = findViewById<TextView>(R.id.etDateOfBirth).text.toString()
//            val country = findViewById<TextView>(R.id.etCountry).text.toString()
//
//            Log.d("MainActivity", "${firstName} $lastName, born on $birthDate, from $country just applied to the formula.")
//        }

        val btnCount = findViewById<Button>(R.id.btnCount)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        var count = 0
        btnCount.setOnClickListener {
            count++
            tvCount.text = "Let's count together: $count"
        }
        btnDecrement.setOnClickListener {
            count--
            tvCount.text = "Let's count together: $count"
        }
        btnReset.setOnClickListener {
            count = 0
            tvCount.text = "Let's count together: $count"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}