package com.example.leomt.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.TextView

class CheatActivity : AppCompatActivity() {
    var mShowAnswerButton : Button? = null
    var mTextViewQuestion : TextView? = null
    var mTextViewAnswer : TextView? = null
    var mAnswerIsTrue : Boolean? = null

    companion object {

        val EXTRA_ANSWER_IS_TRUE = "private_ID"
        fun newIntent(context: Context, answerIsTrue : Boolean?): Intent {
            val intent = Intent(context, CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            return intent
        }

        val EXTRA_ANSWER_SHOWN = "private_name"
        fun wasAnswerShown(result: Intent): Boolean {
            return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat)
        mAnswerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        mTextViewQuestion = findViewById(R.id.tv1)
        mTextViewAnswer = findViewById(R.id.tv2)
        mShowAnswerButton = findViewById(R.id.btnShowAnswer)
        mShowAnswerButton?.setOnClickListener {
            if(mAnswerIsTrue == true) mTextViewAnswer?.setText("True")
            else  mTextViewAnswer?.setText("False")
            setAnswerShownResult(true)

            val cx = mShowAnswerButton?.getWidth()!! / 2
            val cy = mShowAnswerButton?.getHeight()!! / 2
            val radius = mShowAnswerButton?.getWidth()?.toFloat()
            val anim = ViewAnimationUtils.createCircularReveal(mShowAnswerButton, cx, cy, radius!!, 0f)
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    mShowAnswerButton?.setVisibility(View.INVISIBLE)
                }
            })
            anim.start()
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent()
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        setResult(Activity.RESULT_OK, data)
    }

}