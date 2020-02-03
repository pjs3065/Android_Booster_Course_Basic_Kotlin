package com.practice.demofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.detail_view.*
import kotlinx.android.synthetic.main.detail_view.view.*

class DetailsFragment:Fragment() {
    companion object{
        fun newInstance(position:Int):DetailsFragment{
            val df = DetailsFragment()
            val args = Bundle()
            args.putInt("position",position)
            df.arguments = args
            return df
        }
    }

    fun getPosition() = arguments!!.getInt("position",0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.detail_view, container, false)
        v.details.text = BookInfo.DETAILS[getPosition()]
        return v
    }
}