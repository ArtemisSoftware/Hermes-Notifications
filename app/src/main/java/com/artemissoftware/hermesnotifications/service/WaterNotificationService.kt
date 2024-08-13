package com.artemissoftware.hermesnotifications.service

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.artemissoftware.hermesnotifications.NotificationConstants.CHANNEL_ID
import com.artemissoftware.hermesnotifications.R

class WaterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotification() {
        val notification = getNotification()
            .build()

        notificationManager.notify(1, notification)
    }

    private fun getNotification() = NotificationCompat.Builder(context, CHANNEL_ID)
        .setContentTitle("Water Reminder")
        .setContentText("Time to drink some water!")
        .setSmallIcon(R.drawable.ic_hermes)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
}