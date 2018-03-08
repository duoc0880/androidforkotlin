package com.example.leomt.myapplication

/**
 * Created by LEOMT on 3/3/18.
 */
 class Question {
    var mTextResId : Int? = 0
    var mAnswerTrue : Boolean? = false
    var mcheck : Int? = 0

     constructor (textResId : Int, answerTrue : Boolean , check : Int){
            mTextResId = textResId
            mAnswerTrue = answerTrue
            mcheck  = check
    }

    fun setAnswerTrue( answerTrue: Boolean) {
         mAnswerTrue = answerTrue
    }


}


