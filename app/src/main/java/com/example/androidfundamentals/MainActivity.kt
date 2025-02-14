package com.example.androidfundamentals

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
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

        val btnApply = findViewById<Button>(R.id.btnApply)

        btnApply.setOnClickListener {
            val firstName = findViewById<TextView>(R.id.etFirstName).text.toString()
            val lastName = findViewById<TextView>(R.id.etLastName).text.toString()
            val birthDate = findViewById<TextView>(R.id.etDateOfBirth).text.toString()
            val country = findViewById<TextView>(R.id.etCountry).text.toString()

            Log.d("MainActivity", "${firstName} $lastName, born on $birthDate, from $country just applied to the formula.")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}