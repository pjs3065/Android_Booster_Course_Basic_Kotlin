package com.practice.demofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail_view.view.*

class DetailFragment: Fragment() {

    //프래그먼트 생성
    companion object{
        fun newInstance(position:Int):DetailFragment{
            val detailFragment = DetailFragment()
            val args = Bundle()
            args.putInt("position", position)
            detailFragment.arguments = args
            return detailFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //뷰 생성하고 그 뷰에 텍스트 설정후 리턴
        val view = inflater.inflate(R.layout.fragment_detail_view, container, false)
        view.details.text = BookInfo.DETAILS[getPosition()]
        return view
    }

    /**
     * argument 값 가져오기
     */
    fun getPosition() = arguments!!.getInt("position",0)
}