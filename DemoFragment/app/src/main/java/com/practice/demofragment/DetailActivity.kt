package com.practice.demofragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //인텐트 값을 받아서 position 상세보기 프래그먼트로 넘겨주기
        val details = DetailFragment.newInstance(intent.getIntExtra("position",0))
        supportFragmentManager.beginTransaction().add(android.R.id.content, details).commit()
    }
}