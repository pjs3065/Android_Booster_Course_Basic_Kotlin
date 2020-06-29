package com.practice.demodialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 기본 다이얼로그 띄우기
     */
    fun showAlertDialogBasic(v:View?) {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_launcher_foreground)
            .setTitle(getString(R.string.title))
            .setMessage(getString(R.string.message))
            .setNeutralButton(getString(R.string.exit), null)
            .show()
    }

    /**
     * 빌더패턴 안쓰고 기본 다이얼로그 띄우기
     */
    fun showAlertDialogSameBasic(v:View?) {
        val dialog = AlertDialog.Builder(this)
        dialog.setIcon(R.drawable.ic_launcher_foreground)
        dialog.setTitle(getString(R.string.title))
        dialog.setMessage(getString(R.string.message))
        dialog.setNeutralButton(getString(R.string.exit), null)
        dialog.show()
    }

    /**
     * 리스트 형식의 다이얼로그 띄우기
     */
    fun showAlertDialogList(v:View?) {
        val cars = arrayOf("SM3", "SM5", "SM7", "SONATA", "AVANTE")

        AlertDialog.Builder(this)
            .setItems(cars, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "cars: ${cars[which]}", Toast.LENGTH_SHORT)
                        .show()
                }
            }).setNeutralButton(getString(R.string.exit), null).show()
    }

    /**
     * 라디오 버튼 형식의 다이얼로그 띄우기
     */
    fun showAlertDialogSingleChoice(v:View?) {
        val cars = arrayOf("SM3", "SM5", "SM7", "SONATA", "AVANTE")

        AlertDialog.Builder(this)
            .setSingleChoiceItems(cars, -1, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "cars: ${cars[which]}", Toast.LENGTH_SHORT)
                        .show()
                }
            }).setNeutralButton(getString(R.string.exit), null).show()
    }

    /**
     * 체크박스 형식의 다이얼로그 띄우기
     */
    fun showAlertDialogMultiChoice(v:View?) {
        val cars = arrayOf("SM3", "SM5", "SM7", "SONATA", "AVANTE")

        AlertDialog.Builder(this)
            .setMultiChoiceItems(cars, null, object : DialogInterface.OnMultiChoiceClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                    Toast.makeText(this@MainActivity, "cars: ${cars[which]}", Toast.LENGTH_SHORT)
                        .show()
                }
            }).setNeutralButton(getString(R.string.exit), null).show()
    }
}

