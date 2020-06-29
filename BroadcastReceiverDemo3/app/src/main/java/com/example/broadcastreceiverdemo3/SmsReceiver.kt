package com.example.broadcastreceiverdemo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class SmsReceiver:BroadcastReceiver() {

    companion object{
        const val ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        var sender = ""
        var message = ""
        val action = intent?.action

        if(action == ACTION_SMS_RECEIVED)
        {
            val bundle = intent.extras

            if(bundle != null){
                val pdus = bundle.get("pdus") as Array<*>

                pdus.forEach {
                    val smsMessage = SmsMessage.createFromPdu((it as ByteArray), ACTION_SMS_RECEIVED)
                    message += smsMessage.messageBody

                    if(sender == ""){
                        sender = smsMessage.originatingAddress!!
                    }
                }

                Toast.makeText(context, "${sender}:${message}", Toast.LENGTH_LONG).show()
                abortBroadcast()
            }
        }
    }
}