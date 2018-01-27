package com.example.leomt.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var tv : TextView? = null
    var btnTrue : Button? = null
    var btnFalse : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)


        btnTrue?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val toast = Toast.makeText(this@MainActivity, R.string.correct_toast, Toast.LENGTH_SHORT)
                toast.setGravity(48,17,17)
                toast.show()

            }
        })

        btnFalse?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val toast = Toast.makeText(this@MainActivity, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                toast.setGravity(48,17,17)
                toast.show()


            }
        })
    }
}
