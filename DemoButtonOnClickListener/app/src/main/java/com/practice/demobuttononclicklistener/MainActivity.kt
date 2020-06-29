package com.practice.demobuttononclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tagName = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //익명 객체를 만들어서 버튼에 클릭 이벤트 주기
        button1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(tagName, "onClick")
            }
        })
    }
}
