package com.example.leomt.criminalintent

import android.content.Context
import java.util.*

/**
 * Created by LEOMT on 3/29/18.
 */

class CrimeLab {

    companion object {
        var sCrimeLab: CrimeLab? = null

        fun CrimeLab(context: Context) : CrimeLab? {
            if ( sCrimeLab == null ) {
                sCrimeLab = CrimeLab (context)
            }
            return sCrimeLab

        }
    }

    var mCrimes : List<Crime>? = null

    constructor( context : Context){
        var mCrimes = ArrayList<Crime>()
        for ( i in 0..99 ) {
           var crime = Crime()
           crime.mTittle = " Crime # " + i
         //  crime.mSlove = i%2 == 0
           mCrimes.add(crime)
        }
        this.mCrimes = mCrimes
    }

    fun getCrimes() : List<Crime>? {
        return mCrimes
    }

    fun getCrime( id : UUID ) : Crime? {
      //  var crime : Crime
        for (crime in mCrimes!!) {
            if (crime.mId!!.equals(id)) {
                return crime
            }
        }
        return null
    }

}