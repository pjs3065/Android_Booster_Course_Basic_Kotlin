package com.example.alarmmanagerdemo2

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.alarmmanagerdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val alarmManager by lazy { getSystemService(Context.ALARM_SERVICE) as AlarmManager }
    private val alarmIntent by lazy { Intent(this, AlarmReceiver::class.java) }
    private val pendingIntent by lazy { PendingIntent.getBroadcast(this, 0, alarmIntent, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun doAlarm(view: View?) {
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000L, pendingIntent)
    }
}