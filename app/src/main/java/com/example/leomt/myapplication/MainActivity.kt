package com.example.leomt.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "QuizActivity"
    val KEY_INDEX = " index "
    var btnTrue : Button? = null
    var btnFalse : Button? = null
    var imgbtnNext : ImageButton? = null
    var mQuestionTextView : TextView? = null
    var mBtnCheat : Button? = null
    var mCurrentIndex : Int = 0
    var score : Double? = 0.0
    var percent : Double? = 0.0
    var mQuestionBank = arrayOf(Question(R.string.Question_autralia, true,0), Question(R.string.Question_america,false,0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle) called")

        setContentView(R.layout.activity_main)

        if (savedInstanceState != null ) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0)
        }
        mQuestionTextView = findViewById(R.id.tv)
        mQuestionTextView?.setText(mQuestionBank[mCurrentIndex].mTextResId!!)

        btnTrue = findViewById(R.id.btn1)
        btnFalse = findViewById(R.id.btn2)
        imgbtnNext = findViewById(R.id.imgbtn2)

        btnTrue?.setOnClickListener() {
            CheckAnswer(true)
            btnTrue?.isEnabled = false
            mQuestionBank[mCurrentIndex].mcheck = 1
        }
        btnFalse?.setOnClickListener() {
            CheckAnswer(false)
            btnFalse?.isEnabled = false
            mQuestionBank[mCurrentIndex].mcheck = 1
        }
        mBtnCheat = findViewById(R.id.btnCheat)
        mBtnCheat?.setOnClickListener { 
            val intent = Intent(this, CheatActivity::class.java)
            startActivity(intent)
        }
        
        imgbtnNext?.setOnClickListener() {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            var total : Int? = 0
            total = mQuestionBank.size
            UpdateQuestion()
            if (mQuestionBank[mCurrentIndex].mcheck == 0) {
                btnTrue?.isEnabled = true
                btnFalse?.isEnabled = true
            }
            if (mCurrentIndex == 0) {
               percent = score?.div(total)?.times(100.0)
               Toast.makeText(this, "you has been ${percent} % per score for the quiz ", Toast.LENGTH_SHORT ).show()
            }

        }
    }

        fun UpdateQuestion() {
            var question: Int? = 0
         //   Log.i(TAG, "Updating question text", Exception())
            question = mQuestionBank[mCurrentIndex].mTextResId
            mQuestionTextView?.setText(question!!)

        }

        fun CheckAnswer(userPressTrue: Boolean) {
         //   Log.d(TAG, "Toi da di den day")
            var answerIsTrue: Boolean
            var messResId: Int = 0
            answerIsTrue = mQuestionBank[mCurrentIndex].mAnswerTrue!!
            if (answerIsTrue == userPressTrue) {
                messResId = R.string.Correct
                score = score?.plus(1)
            } else messResId = R.string.InCorrect
            Toast.makeText(this, messResId, Toast.LENGTH_SHORT).show()
        }
    }
