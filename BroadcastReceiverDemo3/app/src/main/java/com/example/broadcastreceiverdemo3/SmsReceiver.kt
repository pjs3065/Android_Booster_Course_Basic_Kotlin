package com.example.broadcastreceiverdemo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        var sender = ""
        var receivedMessage = ""
        val action = intent?.action

        if(action == ACTION_SMS_RECEIVED)
        {
            val bundle = intent.extras
            val message = bundle?.get("pdus") as Array<Any>
            val smsMessage = arrayOfNulls<SmsMessage>(message.size)

            for(i in message.indices) {
                smsMessage[i] = SmsMessage.createFromPdu(message[i] as ByteArray, ACTION_SMS_RECEIVED)
                receivedMessage += smsMessage[i]?.messageBody.toString()

                if(sender == ""){
                    sender = smsMessage[i]?.originatingAddress!!
                }
            }

            Toast.makeText(context, "${sender}:${message}", Toast.LENGTH_LONG).show()
            abortBroadcast()
        }
    }
}