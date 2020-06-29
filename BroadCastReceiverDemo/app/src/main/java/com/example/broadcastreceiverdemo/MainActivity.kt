package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.broadcastreceiverdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val batteryIntent by lazy { IntentFilter(Intent.ACTION_BATTERY_CHANGED) }

    private val batteryReceiver = object : BroadcastReceiver() {

        var intent: Intent? = null

        override fun onReceive(context: Context?, intent: Intent?) {
            this.intent = intent

            mBinding.run {
                tvPlugged.text = getPlugged()
                tvStatus.text = getStatus()
                tvLevel.text = getLevel()
            }
        }

        private fun getPlugged(): String {
            val plugged = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
            var pluggedStr = ""

            when (plugged) {
                BatteryManager.BATTERY_PLUGGED_AC -> pluggedStr = "BATTERY_PLUGGED_AC" // AC 전원
                BatteryManager.BATTERY_PLUGGED_USB -> pluggedStr = "BATTERY_PLUGGED_USB" // USB 연결
                else -> pluggedStr = "NO CONNECTING"
            }

            return pluggedStr
        }

        private fun getStatus(): String {
            val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, 0)
            var statusStr = ""

            when(status){
                BatteryManager.BATTERY_STATUS_UNKNOWN -> statusStr = "BATTERY_STATUS_UNKNOWN" //알수 없는 상태
                BatteryManager.BATTERY_STATUS_CHARGING -> statusStr = "BATTERY_STATUS_CHARGING" //충전 중인 상태
                BatteryManager.BATTERY_STATUS_DISCHARGING -> statusStr = "BATTERY_STATUS_DISCHARGING" // 방전 중인 상태
                BatteryManager.BATTERY_STATUS_NOT_CHARGING -> statusStr = "BATTERY_STATUS_UNKNOWN" //충전 중이지 않은 상태
                BatteryManager.BATTERY_STATUS_FULL -> statusStr = "BATTERY_STATUS_FULL" //완전 충전인 상태
            }
            return statusStr
        }

        private fun getLevel(): String {
            val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)
            return "${level}%"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //리시버 등록
        registerReceiver(batteryReceiver, batteryIntent)
    }

    override fun onStop() {
        super.onStop()

        //리시버 해제
        unregisterReceiver(batteryReceiver)
    }
}