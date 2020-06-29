package com.example.alarmmanagerdemo

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.alarmmanagerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var mBinding: ActivityMainBinding
    private val alarmManager by lazy { getSystemService(Context.ALARM_SERVICE) as AlarmManager }
    private val alarmIntent by lazy { Intent(INTENT_ACTION) }
    private val pendingIntent by lazy { PendingIntent.getActivity(this,0, alarmIntent,0) }

    companion object{
        private const val INTENT_ACTION = "com.example.alarmmanagerdemo.alarm"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.run {
            btnRegister.setOnClickListener {
                //알람 설정
                setAlarm(3000L)
            }
            btnCancel.setOnClickListener {
                //알람 해제
                cancelAlarm()
            }
            btnRepeat.setOnClickListener {
                //알람 주기적 등록
                setRepeatingAlarm(3000L, 2000L)
            }
        }
    }

    private fun setAlarm(second: Long){
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + second, pendingIntent)
    }

    private fun setRepeatingAlarm(second:Long, interval:Long){
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + second, interval, pendingIntent)
    }

    private fun cancelAlarm(){
        alarmManager.cancel(pendingIntent)
    }
}