package com.example.alarmmanagerdemo

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class AlarmActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        textView.text = "알람 액티비티"
        setContentView(textView)
    }
}