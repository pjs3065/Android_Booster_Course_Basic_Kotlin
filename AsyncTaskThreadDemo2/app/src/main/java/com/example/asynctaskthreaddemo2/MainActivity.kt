package com.example.asynctaskthreaddemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.asynctaskthreaddemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mHandler1: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.run {
            btnStartCount.setOnClickListener {
                doit(mHandler1)
            }

            btnTest.setOnClickListener {
                Toast.makeText(this@MainActivity, "테스트 버튼이 클릭되었음", Toast.LENGTH_SHORT).show()
            }
        }

//        // 서로 다른 스레드가 있다면 어떻게 동작하는지 알아보기 위해서 추가했음.
//        mHandler1 = Handler(Looper.getMainLooper()) {
//            mBinding.tvResult2.text = "${it.what + 1}"
//            true
//        }
//
//        mHandler2 = Handler(Looper.getMainLooper()) {
//            mBinding.tvResult2.text = "${it.what + 1}"
//            true
//        }
    }

    private fun doit(handler: Handler) {
        object : Thread() {
            override fun run() {
                loop(handler)
            }
        }.start()
    }

    private fun loop(handler: Handler) {
        for (i in 1..100) {
            try {

                //Runnable 객체 사용하기
                handler.post {
                    mBinding.tvResult1.text = "${i}초"
                }
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

