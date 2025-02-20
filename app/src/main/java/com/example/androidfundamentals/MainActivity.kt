package com.example.androidfundamentals

import android.Manifest
import android.annotation.SuppressLint
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
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
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


//        val btnApply = findViewById<Button>(R.id.btnApply)
//        val etName = findViewById<EditText>(R.id.etName)
//        val etAge = findViewById<EditText>(R.id.etAge)
//        val etCountry = findViewById<EditText>(R.id.etCountry)
//
//        btnApply.setOnClickListener {
//            val name = etName.text.toString()
//            val age = etAge.text.toString().toInt()
//            val country = etCountry.text.toString()
//
//            Intent(this, SecondActivity::class.java).also {
//                it.putExtra("EXTRA_NAME", name)
//                it.putExtra("EXTRA_AGE", age)
//                it.putExtra("EXTRA_COUNTRY", country)
//                startActivity(it)
//            }
//        }


        val btnRequestPermissions = findViewById<Button>(R.id.btnRequestPermissions)
        btnRequestPermissions.setOnClickListener {
            requestPermissions()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private companion object {
        const val PERMISSION_REQUEST_CODE = 100
        const val BACKGROUND_LOCATION_REQUEST_CODE = 101
    }

    private fun requestPermissions() {
        val permissionsToRequest = mutableListOf<String>()

        // Check storage permission
        if (!hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        // Check foreground location permission
        if (!hasLocationForegroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()) {
            // First request foreground permissions
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                PERMISSION_REQUEST_CODE
            )
        } else {
            // If foreground permissions are granted, check for background location
            requestBackgroundLocationPermission()
        }
    }

    private fun requestBackgroundLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (hasLocationForegroundPermission() && !hasLocationBackgroundPermission()) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                    // Show explanation to the user why you need background location
                    showBackgroundLocationRationale()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                        BACKGROUND_LOCATION_REQUEST_CODE
                    )
                }
            }
        }
    }

    private fun showBackgroundLocationRationale() {
        AlertDialog.Builder(this)
            .setTitle("Background Location Permission")
            .setMessage("We need background location access to provide continuous location updates even when the app is in background.")
            .setPositiveButton("Grant") { _, _ ->
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    BACKGROUND_LOCATION_REQUEST_CODE
                )
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty()) {
                    for (i in permissions.indices) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Log.d("PermissionRequest", "${permissions[i]} granted")

                            // If foreground location was just granted, request background
                            if (permissions[i] == Manifest.permission.ACCESS_COARSE_LOCATION) {
                                requestBackgroundLocationPermission()
                            }
                        } else {
                            Log.d("PermissionRequest", "${permissions[i]} denied")
                        }
                    }
                }
            }
            BACKGROUND_LOCATION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "Background location granted")
                } else {
                    Log.d("PermissionRequest", "Background location denied")
                }
            }
        }
    }

    // Your existing permission check functions remain the same
    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

}