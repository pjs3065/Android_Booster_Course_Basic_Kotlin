package com.practice.demonotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private val channelId = "sampleChannel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //다이얼 창으로 넘겨주는 메시지
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"))

        //나중에 보낼 메시지
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //오레오 버전 위부터는 채널을 만들어 관리해야한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelName = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance )
            channel.description = descriptionText
            notificationManager.createNotificationChannel(channel)
        }

        //통지 객체 만들기
        val notification = NotificationCompat.Builder(this,channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.title))
            .setContentText(getString(R.string.message))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        //통지 띄우기
        notificationManager.notify(0,notification)
    }
}
