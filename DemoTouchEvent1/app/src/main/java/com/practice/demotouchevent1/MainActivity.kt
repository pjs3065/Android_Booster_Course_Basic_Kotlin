package com.practice.demotouchevent1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {

    private val tagName = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰를 상속받은 커스텀뷰 만들기
        val customView = CustomView(this)

        //커스텀뷰에 터치 이벤트 리스너 등록하기
        customView.setOnTouchListener(object: View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (event!!.action == MotionEvent.ACTION_DOWN) {
                    Log.d(tagName, "onTouch : CustomView 익명객체")
                    return false
                }
                return true
            }
        })
        setContentView(customView)
    }

    //메인 엑티비티가 선택될때 호출된다.
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_DOWN){
            Log.d(tagName, "onTouchEvent : 엑티비티에 선언")
            return false
        }
        return true
    }
}
