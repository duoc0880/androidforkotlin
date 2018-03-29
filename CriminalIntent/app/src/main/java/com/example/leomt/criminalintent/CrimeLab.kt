package com.example.leomt.criminalintent

import android.content.Context

/**
 * Created by LEOMT on 3/29/18.
 */

class CrimeLab {

    companion object {
        var sCrimeLab: CrimeLab? = null
        var mCrimes : List<Crime>? = null


        fun CrimeLab(context: Context) : CrimeLab? {
            if ( sCrimeLab == null ) {
                sCrimeLab = CrimeLab (context)
            }
            return sCrimeLab

        }
    }

    constructor( context : Context){
        val mCrimes = ArrayList<Crime>()

        CrimeLab.mCrimes = mCrimes
    }
}