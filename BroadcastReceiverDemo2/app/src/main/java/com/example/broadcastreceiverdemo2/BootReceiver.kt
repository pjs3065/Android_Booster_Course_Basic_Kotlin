package com.example.broadcastreceiverdemo2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("BootReceiver", "ok")
        val i = Intent(context, MainActivity::class.java)

        //인텐트 프래그 설정
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        //메인 액티비티 실행
        context?.startActivity(i)
    }
}