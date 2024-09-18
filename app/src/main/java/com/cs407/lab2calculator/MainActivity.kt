package com.cs407.lab2calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputOne = findViewById<EditText>(R.id.inputOne)
        val inputTwo = findViewById<EditText>(R.id.inputTwo)
        val add = findViewById<Button>(R.id.add)
        val subtract = findViewById<Button>(R.id.subtract)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)

        add.setOnClickListener {
            val result = (inputOne.text.toString().toInt() + inputTwo.text.toString().toInt()).toString()

            // create intent to navigate to calculator
            val intent = Intent(this, calculatorResult::class.java )

            intent.putExtra("EXTRA_MESSAGE", result)
            //start new activity
            startActivity(intent)
            Log.i("INFO", "Button Clicked!")
        }
        subtract.setOnClickListener {
            val result = (inputOne.text.toString().toInt() - inputTwo.text.toString().toInt()).toString()

            // create intent to navigate to calculator
            val intent = Intent(this, calculatorResult::class.java )

            intent.putExtra("EXTRA_MESSAGE", result)
            //start new activity
            startActivity(intent)
            Log.i("INFO", "Button Clicked!")
        }
        multiply.setOnClickListener {
            val result = (inputOne.text.toString().toInt() * inputTwo.text.toString().toInt()).toString()

            // create intent to navigate to calculator
            val intent = Intent(this, calculatorResult::class.java )

            intent.putExtra("EXTRA_MESSAGE", result)
            //start new activity
            startActivity(intent)
            Log.i("INFO", "Button Clicked!")
        }
        divide.setOnClickListener {
            if (inputTwo.text.toString().toInt() == 0){
                Toast.makeText(this, "cannot divide by 0", Toast.LENGTH_SHORT).show()
            }
            else {
                val result =
                    (inputOne.text.toString().toDouble() / inputTwo.text.toString().toDouble()).toString()

                // create intent to navigate to calculator
                val intent = Intent(this, calculatorResult::class.java)

                intent.putExtra("EXTRA_MESSAGE", result)
                //start new activity
                startActivity(intent)
            }
            Log.i("INFO", "Button Clicked!")

        }

    }

}