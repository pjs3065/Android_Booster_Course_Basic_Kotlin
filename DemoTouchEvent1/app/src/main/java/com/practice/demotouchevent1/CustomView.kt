package com.practice.demotouchevent1

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {

    private val tagName = MainActivity::class.java.simpleName

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_DOWN){
            Log.d(tagName, "onTouchEvent : CustomView 구현")
            return false
        }
        return true
    }
}