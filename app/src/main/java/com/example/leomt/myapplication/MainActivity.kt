package com.example.leomt.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "QuizActivity"
    private val KEY_INDEX = "index"

    var btnTrue : Button? = null
    var btnFalse : Button? = null
    var imgbtnNext : ImageButton? = null
    var mQuestionTextView : TextView? = null
    var mCurrentIndex : Int = 0

    var mQuestionBank = arrayOf(Question(R.string.Question_autralia, true,0), Question(R.string.Question_america,false,0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTrue = findViewById(R.id.btn1)
        btnFalse = findViewById(R.id.btn2)
        mQuestionTextView = findViewById(R.id.tv)
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
        imgbtnNext?.setOnClickListener() {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            UpdateQuestion()
            if (mQuestionBank[mCurrentIndex].mcheck == 0) {
                btnTrue?.isEnabled = true
                btnFalse?.isEnabled = true
            }

        }
    }

        fun UpdateQuestion() {
            var question: Int? = 0
            question = mQuestionBank[mCurrentIndex].mTextResId
            mQuestionTextView?.setText(question!!)

        }

        fun CheckAnswer(userPressTrue: Boolean) {
            var answerIsTrue: Boolean
            var messResId: Int = 0
            answerIsTrue = mQuestionBank[mCurrentIndex].mAnswerTrue!!
            if (answerIsTrue == userPressTrue) {
                messResId = R.string.Correct
            } else messResId = R.string.InCorrect
            Toast.makeText(this, messResId, Toast.LENGTH_SHORT).show()
        }
    }








