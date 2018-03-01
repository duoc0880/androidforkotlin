package com.example.leomt.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var btn1 : Button? = null
    var btn2 : Button? = null
    var btn3 : Button? = null
    var btn4 : Button? = null
    var tv : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        tv = findViewById(R.id.tv)

        btn1!!.setOnClickListener(){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        }

        btn2!!.setOnClickListener(){
            Toast.makeText(this, "Uncorrect", Toast.LENGTH_SHORT).show()
        }
    }
}


