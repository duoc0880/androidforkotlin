package com.example.leomt.criminalintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class CreamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cream)

        var fm : FragmentManager = supportFragmentManager
        var fragment : Fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) run {
            var fragment = CrimeFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}