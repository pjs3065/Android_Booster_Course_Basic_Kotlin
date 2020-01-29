package com.practice.demodialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_launcher_foreground)
            .setTitle(getString(R.string.title))
            .setMessage(getString(R.string.message))
            .setNeutralButton(getString(R.string.exit), null)
            .show()


//        //같은 코드
//        val dialog = AlertDialog.Builder(this)
//        dialog.setIcon(R.drawable.ic_launcher_foreground)
//        dialog.setTitle(getString(R.string.title))
//        dialog.setMessage(getString(R.string.message))
//        dialog.setNeutralButton(getString(R.string.exit), null)
//        dialog.show()
    }
}

