package com.practice.demofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayListFragment()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        ft.add(android.R.id.content, list)
        ft.commit()
    }
}
