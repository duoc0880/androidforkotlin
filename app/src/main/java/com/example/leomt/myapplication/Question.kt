package com.example.leomt.myapplication

/**
 * Created by LEOMT on 3/3/18.
 */
 class Question {
    var mTextResId : Int? = 0
    var mAnswerTrue : Boolean? = false

     constructor (textResId : Int, answerTrue : Boolean ){
            mTextResId = textResId
            mAnswerTrue = answerTrue
    }

    fun setAnswerTrue( answerTrue: Boolean) {
         mAnswerTrue = answerTrue
    }


}

