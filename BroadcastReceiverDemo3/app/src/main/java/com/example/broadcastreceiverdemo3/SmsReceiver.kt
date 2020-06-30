package com.example.broadcastreceiverdemo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SmsReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
//        private const val SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
//        private const val TAG = "SmsReceiver"
//
//        @SuppressLint("SimpleDateFormat")
//        private val format = SimpleDateFormat("yyyy-MM-dd HH:mm");

    }

    override fun onReceive(context: Context?, intent: Intent?) {
        var sender = ""
        var message = ""
        val action = intent?.action

        if (action == SmsRetriever.SMS_RETRIEVED_ACTION) {
            val extras = intent.extras
            when ((extras?.get(SmsRetriever.EXTRA_STATUS) as Status).statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                }
            }

        }
    }
}