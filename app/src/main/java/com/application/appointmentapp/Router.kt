package com.application.appointmentapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity

class Router {

    fun startBookAppointmentActivity(context: Context, bundle: Bundle?) {
        val intent = Intent(context, BookAppointmentActivity::class.java)
        startActivity(context, intent, bundle)
    }

    fun startAppointmentHistoryActivity(context: Context) {
        val intent = Intent(context, AppointmentHistoryActivity::class.java)
        startActivity(context, intent, null)
    }

    fun startShowPackageActivity(context: Context, title: String) {
        val intent = Intent(context, ShowPackageActivity::class.java)
        intent.putExtra("category", title)
        context.startActivity(intent)
    }
}