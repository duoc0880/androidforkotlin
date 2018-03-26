package com.example.leomt.criminalintent

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class CrimeFragment : android.support.v4.app.Fragment()
{
    var mCrime : Crime? = null
    var mTitleField : EditText? = null
    var mDateButton : Button? = null
    var mSloveCheckBox: CheckBox? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCrime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v : View
        v = inflater!!.inflate(R.layout.fragment_crime, container, false)

        mTitleField = v.findViewById(R.id.crime_title)
        mTitleField?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        mDateButton = v.findViewById(R.id.crime_date)
        mDateButton?.setText(mCrime?.mDate?.toString())
        mDateButton?.isEnabled = false

        mSloveCheckBox = v.findViewById(R.id.crime_cb)
        mSloveCheckBox?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                mCrime?.mSlove = p1

            }
        })


        return v
    }
}


