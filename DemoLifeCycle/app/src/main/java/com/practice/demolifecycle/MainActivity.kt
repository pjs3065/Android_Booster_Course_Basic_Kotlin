package com.practice.demolifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "ActivityLife"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag,"onCreate()")

        button1.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(tag,"onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(tag,"onRestoreInstanceState()")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.d(tag,"onUserLeaveHint")
    }
}