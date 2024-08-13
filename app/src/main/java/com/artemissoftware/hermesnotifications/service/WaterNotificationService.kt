package com.artemissoftware.hermesnotifications.service

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
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

    fun showExpandableNotification() {
        val image = context.bitmapFromResource(R.drawable.hermes_2)

        val notification = getNotification()
            .setLargeIcon(image)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(image)
                    .bigLargeIcon(null as Bitmap?)
            )
            .build()

        notificationManager.notify(
            2,
            notification
        )
    }

    private fun getNotification() = NotificationCompat.Builder(context, CHANNEL_ID)
        .setContentTitle("Water Reminder")
        .setContentText("Time to drink some water!")
        .setSmallIcon(R.drawable.ic_hermes)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )
}