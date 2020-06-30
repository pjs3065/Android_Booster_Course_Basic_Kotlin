package com.example.broadcastreceiverdemo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.broadcastreceiverdemo3.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.phone.SmsRetrieverClient
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var client: SmsRetrieverClient
    private var smsRetrieverReceiver: BroadcastReceiver? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        registerSmsRetrieverReceiver()

        // 준비가 되면 SMS Retriever를 시작시켜준다. 인증코드 재전송시에 재호출해주어야 한다.
        client = SmsRetriever.getClient(this).also {
            it.startSmsRetriever()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterSmsRetrieverReceiver()
    }

    private fun registerSmsRetrieverReceiver() {
        smsRetrieverReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
                    val extras = intent.extras ?: return
                    val status = extras.get(SmsRetriever.EXTRA_STATUS) as? Status ?: return

                    if (status.statusCode != CommonStatusCodes.SUCCESS) {
                        return
                    }
                    val message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE)
                }
                registerReceiver(
                    smsRetrieverReceiver,
                    IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
                )
            }
        }
    }

    private fun unregisterSmsRetrieverReceiver() {
        if (smsRetrieverReceiver != null) {
            unregisterReceiver(smsRetrieverReceiver)
            smsRetrieverReceiver = null
        }
    }
}