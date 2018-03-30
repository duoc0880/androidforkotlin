package com.example.leomt.criminalintent

import java.util.*

class Crime {

    var mId : UUID? = null
    var mTittle : String? = null
    var mDate : Date? = null
    var mSlove : Boolean? = false

    constructor(){
        mId = UUID.randomUUID()
        mDate = Date()
    }



}