package com.example.broadcastreceiverdemo3

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.broadcastreceiverdemo3.SmsReceiver.Companion.ACTION_SMS_RECEIVED
import com.example.broadcastreceiverdemo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val smsReceiver by lazy { SmsReceiver() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction(ACTION_SMS_RECEIVED)

        //SMS 리시버 등록
        registerReceiver(smsReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(smsReceiver)
    }
}