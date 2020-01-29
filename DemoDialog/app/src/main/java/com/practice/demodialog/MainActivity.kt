package com.practice.demodialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        showAlertDialogBasic()
//        showAlertDialogSameBasic()
//        showAlertDialogList()
//        showAlertDialogSingleChoice()
        showAlertDialogMultiChoice()
    }

    /**
     * 기본 다이얼로그 띄우기
     */
    private fun showAlertDialogBasic() {
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
    private fun showAlertDialogSameBasic() {
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
    private fun showAlertDialogList() {
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
    private fun showAlertDialogSingleChoice() {
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
    private fun showAlertDialogMultiChoice() {
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

