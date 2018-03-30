package com.example.leomt.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Created by LEOMT on 3/30/18.
 */

abstract class  SingleFragmentActivity : AppCompatActivity() {
    abstract fun createFragment(): Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var fm : FragmentManager = supportFragmentManager

        var fragment = fm.findFragmentById(R.id.fragment_container)

        if (fragment == null) run {
            var fragment = createFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}
