package com.example.androidfundamentals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val btnBack = findViewById<Button>(R.id.btnBack)
//        val btnNextActivity = findViewById<Button>(R.id.btnNextActivity)
//
//        btnBack.setOnClickListener {
//            finish()
//        }
//
//        btnNextActivity.setOnClickListener {
//            Intent(this, ThirdActivity::class.java).also {
//                startActivity(it)
//            }
//        }

        val tvPerson = findViewById<TextView>(R.id.tvPerson)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val personString = "$name is $age years old and lives in $country"

        tvPerson.text = personString
    }
}