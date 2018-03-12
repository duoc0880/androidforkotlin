package com.example.leomt.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class CheatActivity : MainActivity() {
    var mBtnShowAnswer : Button? = null
    var mTextViewQuestion : TextView? = null
    var mTextViewAnswer : TextView? = null
    var mAnswerIsTrue : Boolean? = null

    companion object {

        private val EXTRA_ANSWER_IS_TRUE = "private_ID"
        fun newIntent(context: Context, answerIsTrue : Boolean?): Intent {
            val intent = Intent(context, CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat)
        mAnswerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        mTextViewQuestion = findViewById(R.id.tv1)
        mTextViewAnswer = findViewById(R.id.tv2)
        mBtnShowAnswer = findViewById(R.id.btnShowAnswer)
        mBtnShowAnswer?.setOnClickListener {
            if(mAnswerIsTrue == true) mTextViewAnswer?.setText("True")
            else  mTextViewAnswer?.setText("False")

        }
    }

}