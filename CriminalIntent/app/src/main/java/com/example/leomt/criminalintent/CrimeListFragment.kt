package com.example.leomt.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast

class CrimeListFragment : Fragment(){
    var mCrimeRecycleView : RecyclerView? = null
    var mAdapter : CrimeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      var  view = inflater!!.inflate(R.layout.fragment_crime_list, container, false)
      mCrimeRecycleView = view.findViewById(R.id.crime_recycler_view)
      mCrimeRecycleView!!.layoutManager  = LinearLayoutManager(activity)
        updateUI()
        return view
    }

    fun updateUI () {
        var crimeLab = CrimeLab(activity)
        var crimes : List<Crime> = crimeLab.getCrimes()!!
        mAdapter = CrimeAdapter(crimes)
        mCrimeRecycleView!!.setAdapter(mAdapter)

    }

     inner class CrimeHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)), View.OnClickListener {

         var mCrime: Crime? = null

         var mTitleTextView: TextView? = null
         var mDateTextView: TextView? = null

        init {
            itemView.setOnClickListener(this)

            mTitleTextView = itemView.findViewById(R.id.crime_title)
            mDateTextView = itemView.findViewById(R.id.crime_date)
        }

        fun bind(crime: Crime) {
            mCrime = crime
            mTitleTextView!!.setText(mCrime!!.mTittle)
            mDateTextView!!.setText(mCrime!!.mDate.toString())
        }

        override fun onClick(view: View) {
            Toast.makeText(activity,
                    mCrime!!.mTittle + " clicked!", Toast.LENGTH_SHORT)
                    .show()
        }
    }


     inner class CrimeAdapter( val mCrimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val layoutInflater = LayoutInflater.from(activity)
            return CrimeHolder(layoutInflater, parent)
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime = mCrimes[position]
            holder.bind(crime)
        }

        override fun getItemCount(): Int {
            return mCrimes.size
        }
    }
}