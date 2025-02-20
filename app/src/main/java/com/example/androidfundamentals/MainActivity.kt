package com.example.androidfundamentals

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.constraintlayout.widget.Group
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent

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

//        val btnCount = findViewById<Button>(R.id.btnCount)
//        val btnDecrement = findViewById<Button>(R.id.btnDecrement)
//        val btnReset = findViewById<Button>(R.id.btnReset)
//        val tvCount = findViewById<TextView>(R.id.tvCount)
//        var count = 0
//        btnCount.setOnClickListener {
//            count++
//            tvCount.text = "Let's count together: $count"
//        }
//        btnDecrement.setOnClickListener {
//            count--
//            tvCount.text = "Let's count together: $count"
//        }
//        btnReset.setOnClickListener {
//            count = 0
//            tvCount.text = "Let's count together: $count"
//        }

//        val btnAdd = findViewById<Button>(R.id.btnAdd)
//        val tvResult = findViewById<TextView>(R.id.tvResult)
//        val etNum1 = findViewById<EditText>(R.id.etFirstNum)
//        val etNum2 = findViewById<EditText>(R.id.etSecondNum)

//        btnAdd.setOnClickListener {
//            val num1 = etNum1.text.toString().toIntOrNull() ?:0
//            val num2 = etNum2.text.toString().toIntOrNull() ?:0
//            val result = num1 + num2
//            tvResult.text = result.toString()
//        }

//        val btnAddImage = findViewById<Button>(R.id.btnAddImage)
//        val ivImage = findViewById<ImageView>(R.id.ivImage)
//        btnAddImage.setOnClickListener {
//            ivImage.setImageResource(R.drawable.puppy)
//        }

//        val btnOrder = findViewById<Button>(R.id.btnOrder)
//        val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)
//        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
//        val cbOnions = findViewById<CheckBox>(R.id.cbOnions)
//        val cbSalads = findViewById<CheckBox>(R.id.cbSalads)
//        val tvOrder = findViewById<TextView>(R.id.tvOrder)
//
//        btnOrder.setOnClickListener {
//            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
//            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
//            val cheese = cbCheese.isChecked
//            val onions = cbOnions.isChecked
//            val salads = cbSalads.isChecked
//
//            val orderString = "You ordered a burger with: \n" +
//                    "${meat.text}" +
//                    (if(cheese) "\nCheese" else "") +
//                    (if(onions) "\nOnions" else "") +
//                    (if(salads) "\nSalads" else "")
//
//            tvOrder.text = orderString
//        }


//        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
//        val clToast = findViewById<Layout>(R.id.clToast)

//        btnShowToast.setOnClickListener {
////            Toast.makeText(this, "Hi, I'm a toast", Toast.LENGTH_LONG).show()
//
////            Custom Toast
////            Toast(this).apply {
////                duration = Toast.LENGTH_LONG
////                view = layoutInflater.inflate(R.Layout)
////            }
//        }

//        val btnOpenActivity = findViewById<Button>(R.id.btnOpenActivity)
//
//        btnOpenActivity.setOnClickListener {
//            Intent(this, SecondActivity::class.java).also {
//                startActivity(it)
//            }
//        }


        val btnApply = findViewById<Button>(R.id.btnApply)
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etCountry = findViewById<EditText>(R.id.etCountry)

        btnApply.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()

            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_AGE", age)
                it.putExtra("EXTRA_COUNTRY", country)
                startActivity(it)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}