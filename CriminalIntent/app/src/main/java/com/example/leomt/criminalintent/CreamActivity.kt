package com.example.leomt.criminalintent

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import java.util.*

class CreamActivity : SingleFragmentActivity() {


    companion object {
        private val EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id"

        fun newIntent(packageContext: Context, crimeId: UUID?): Intent {
            val intent = Intent(packageContext, CreamActivity::class.java)
            intent.putExtra(EXTRA_CRIME_ID, crimeId)
            return intent
        }
    }


     override fun createFragment(): Fragment {
        val crimeId = intent
                .getSerializableExtra(EXTRA_CRIME_ID) as UUID
        return CrimeFragment.newInstance(crimeId)
    }
}