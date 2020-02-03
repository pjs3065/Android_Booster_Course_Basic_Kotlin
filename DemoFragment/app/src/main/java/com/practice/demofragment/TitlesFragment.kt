package com.practice.demofragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment

class TitlesFragment : ListFragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listAdapter = ArrayAdapter<String>(
            activity as Context,
            android.R.layout.simple_list_item_activated_1,
            BookInfo.TITLES
        )
    }


    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var details: DetailsFragment? = fragmentManager?.findFragmentById(R.id.details) as DetailsFragment?

        if (details == null || details.getPosition() != position) {
            details = DetailsFragment.newInstance(position)
            val ft = fragmentManager!!.beginTransaction()
            ft.run {
                replace(R.id.details, details)
                setCustomAnimations(
                    android.R.anim.fade_in, android.R.anim.fade_out,
                    android.R.anim.fade_in, android.R.anim.fade_out
                )
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}