package com.github.yoviep.ktorserverexample.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.github.yoviep.ktorserverexample.R

class NotificationHelper {
    class Option(
        val title: String,
        val content: String,
        val channel: Channel,
        @DrawableRes val smallIcon: Int = R.drawable.ic_launcher_foreground,
        val pendingIntent: PendingIntent? = null,
        val ongoing: Boolean = false,
        val showWhen: Boolean = true
    )

    class Channel(
        val id: String,
        val name: String,
        val description: String
    )

    companion object {
        fun show(context: Context, option: Option) {
            (context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)?.let {
                val notification = create(context, option)
                it.notify(1, notification)
            }
        }

        fun create(context: Context, option: Option): Notification {
            val builder = createNotificationBuilder(context, option)
                .setContentTitle(option.title)
                .setContentText(option.content)
                .setSmallIcon(option.smallIcon)
                .setContentIntent(option.pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setShowWhen(option.showWhen)
                .setSound(null)

            return builder.build()
        }

        private fun createNotificationBuilder(
            context: Context,
            option: Option
        ): NotificationCompat.Builder {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel(context, option)
                return NotificationCompat.Builder(context, option.channel.id)
            } else {
                @Suppress("DEPRECATION")
                return NotificationCompat.Builder(context)
            }
        }

        private fun createNotificationChannel(context: Context, option: Option) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val manager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channel = NotificationChannel(
                    option.channel.id,
                    option.channel.name,
                    NotificationManager.IMPORTANCE_HIGH
                )
                channel.description = option.channel.description
                channel.setSound(null, null)
                manager.createNotificationChannel(channel)
            }
        }
    }
}