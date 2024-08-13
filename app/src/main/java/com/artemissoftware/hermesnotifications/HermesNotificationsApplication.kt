package com.artemissoftware.hermesnotifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.artemissoftware.hermesnotifications.NotificationConstants.CHANNEL_ID
import com.artemissoftware.hermesnotifications.NotificationConstants.CHANNEL_NAME

class HermesNotificationsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        )

        notificationChannel.description = "A notification channel for water reminders"

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}