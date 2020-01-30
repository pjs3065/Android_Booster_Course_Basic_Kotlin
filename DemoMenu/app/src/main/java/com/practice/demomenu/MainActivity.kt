package com.practice.demomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //메뉴 인플레이트해서 가져오기
        menuInflater.inflate(R.menu.menu_items, menu)

        //메뉴를 보여주고 싶으면 true, 아니면 fasle 선언
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                Toast.makeText(this, R.string.menu1, Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu2 -> {
                Toast.makeText(this, R.string.menu2, Toast.LENGTH_SHORT).show()
                return true

            }
            R.id.menu3 -> {
                Toast.makeText(this, R.string.menu3, Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
