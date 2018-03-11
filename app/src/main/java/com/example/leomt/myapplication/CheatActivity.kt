package com.example.leomt.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class CheatActivity : AppCompatActivity() {
    var mBtnShowAnswer : Button? = null
    var mTextViewQuestion : TextView? = null
    var mTextViewAnswer : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat)

        mTextViewQuestion = findViewById(R.id.tv1)
        mTextViewAnswer = findViewById(R.id.tv2)
        mBtnShowAnswer = findViewById(R.id.btnShowAnswer)
        mBtnShowAnswer?.setOnClickListener {

        }
        }

}