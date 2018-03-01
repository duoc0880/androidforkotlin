package com.example.leomt.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var btnTrue : Button? = null
    var btnFalse : Button? = null
    var imgbtnNext : ImageButton? = null
    var imgbtnPrev : ImageButton? = null
    var tv : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTrue = findViewById(R.id.btn1)
        btnFalse = findViewById(R.id.btn2)
        imgbtnNext = findViewById(R.id.imgbtn1)
        imgbtnPrev = findViewById(R.id.imgbtn2)
        tv = findViewById(R.id.tv)

        btnTrue!!.setOnClickListener(){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        }

        btnFalse!!.setOnClickListener(){
            Toast.makeText(this, "Uncorrect", Toast.LENGTH_SHORT).show()
        }
        imgbtnNext!!.setOnClickListener(){

        }
        imgbtnPrev!!.setOnClickListener(){

        }


    }
}


