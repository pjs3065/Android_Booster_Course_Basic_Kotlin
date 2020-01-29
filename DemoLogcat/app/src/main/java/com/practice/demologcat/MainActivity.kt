package com.practice.demologcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Error : 가장 심각한 문제가 발생했을 때 남기는 로그
        Log.e("tag","error message")

        //Warning : 심각하지는 않지만, 나중에라도 문제의 소지가 있을 수 있어서 남기는 로그
        Log.w("tag","warning  message")

        //Information: 어떤 처리를 하면서 발생하는 진행 과정 등을 모니터링 하기 위한 목적으로 남기는 로그
        Log.i("tag","information  message")

        //Debugging: 디버깅 목적으로 문제 발생 가능성이 있는 곳에 남기는 로그
        Log.d("tag","debugging  message")

        //Verbose: 동작 여부를 최대한 자세하게 살펴볼 목적으로 남기는 로그
        Log.v("tag","verbose  message")

        //로그캣 색상 바꾸기
        /**
         * ctrl + alt + s
         * 설정 - editor - android logcat
         */
    }
}
