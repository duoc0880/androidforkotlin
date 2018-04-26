package com.example.leomt.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CrimeListFragment : Fragment(){
    var mCrimeRecycleView : RecyclerView? = null
    var mAdapter : CrimeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      var  view = inflater!!.inflate(R.layout.fragment_crime_list, container, false)
      mCrimeRecycleView = view.findViewById(R.id.crime_recycler_view)
   //   mCrimeRecycleView!!.layoutManager  = LinearLayoutManager(activity)
        mCrimeRecycleView!!.setLayoutManager(LinearLayoutManager(activity))
        updateUI()
        return view
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    fun updateUI () {
        var crimeLab = CrimeLab(activity)
        var crimes : List<Crime> = crimeLab.getCrimes()!!

        if(mAdapter==null) {
            mAdapter = CrimeAdapter(crimes)
            mCrimeRecycleView!!.setAdapter(mAdapter)
        }else
        {
            mAdapter!!.notifyDataSetChanged()
        }
    }

     inner class CrimeHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)), View.OnClickListener {

         var mCrime: Crime? = null
         var mTitleTextView: TextView? = null
         var mDateTextView: TextView? = null
         var mSolvedImageView: ImageView? = null

        init {
            itemView.setOnClickListener(this)
            mTitleTextView = itemView.findViewById(R.id.crime_title)
            mDateTextView = itemView.findViewById(R.id.crime_date)
            mSolvedImageView = itemView.findViewById(R.id.crime_solved)
        }

        fun bind(crime: Crime) {
            mCrime = crime
            mTitleTextView!!.setText(mCrime!!.mTittle)
            mDateTextView!!.setText(mCrime!!.mDate.toString())
            mSolvedImageView!!.setVisibility(if (crime.mSlove!!) View.VISIBLE else View.GONE)
        }

        override fun onClick(view: View) {
            val intent = CreamActivity.newIntent(activity, mCrime!!.mId)
            startActivity(intent)
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