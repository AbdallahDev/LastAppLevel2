package com.example.user.lastapplevel2

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            var i = Intent(this, SecondAct::class.java)

            var n = NotificationCompat.Builder(this)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setContentTitle("My Example")
                    .setContentText("This is test message")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT))

            var nm = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            nm.notify(0, n.build())


        }
    }
}
