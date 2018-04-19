package com.example.leomt.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CrimeListFragment : Fragment(){
    var mCrimeRecycleView : RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      var  view = inflater!!.inflate(R.layout.fragment_crime_list, container, false)
      mCrimeRecycleView = view.findViewById(R.id.crime_recycler_view)
      mCrimeRecycleView!!.layoutManager  = LinearLayoutManager(activity)
        return view
    }

}


