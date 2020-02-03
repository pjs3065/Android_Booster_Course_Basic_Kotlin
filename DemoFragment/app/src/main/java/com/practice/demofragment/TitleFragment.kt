package com.practice.demofragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment

class TitleFragment : ListFragment() {

    //가로 모드인지 식별
    var isDual = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //ListFragment의 setListAdapter로 Array<String> 타입의 BookInfo.TITLES 데이터 넘기기
        listAdapter = ArrayAdapter<String>(
            activity as Context,
            android.R.layout.simple_list_item_activated_1,
            BookInfo.TITLES
        )

        //상세보기 프레임 값 가져오기
        val detailFrame: FrameLayout? = activity!!.findViewById(R.id.details) as FrameLayout?

        //상세보기 프레임이 존재하거나 보여지면, 가로모드
        isDual = detailFrame != null && detailFrame.visibility == View.VISIBLE
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        //가로모드일때
        if (isDual) {
            showFragment(position)
        } else {
            //세로모드일때
            showActivity(position)
        }
    }

    private fun showFragment(position: Int) {

        //상세보기 프래그먼트 가져오기
        var details:DetailFragment? = fragmentManager!!.findFragmentById(R.id.details) as DetailFragment?

        //상세보기 프래그먼트가 없거나, 현재 클릭한 아이템의 포지션과 다르면
        if(details == null || details.getPosition()!= position){

            //상세보기 프래그먼트 생성
            details = DetailFragment.newInstance(position)

            //상세보기 프래그먼트 보여주기
            val ft = fragmentManager!!.beginTransaction()
            ft.run{
                replace(R.id.details, details)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }

    }

    private fun showActivity(position: Int) {

        //상세보기 액티비티로 화면전환
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
    }
}