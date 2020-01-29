package com.practice.demobuttonactivityimplementclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val tagName = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    /**
     * 액티비티에 구현한 클릭 리스너
     */
    override fun onClick(v: View?) {
        Log.d(tagName,"onClick : 액티비티에 구현한 리스너")
    }
}
