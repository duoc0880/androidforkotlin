package com.example.leomt.criminalintent

import android.support.v4.app.Fragment

/**
 * Created by LEOMT on 3/30/18.
 */
 class CrimeListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return CrimeListFragment()
    }
}