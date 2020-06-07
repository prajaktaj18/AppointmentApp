package com.application.appointmentapp

import android.content.Context
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Utility {
    fun getDate(date: String): String {
//       2019-04-21-> 21st, April 2019

        if (!date.equals("")) {
            var parser = SimpleDateFormat()
            if (date.contains("-")) {
                parser = SimpleDateFormat("yyyy-MM-dd")
            } else if (date.contains("/")) {
                parser = SimpleDateFormat("yyyy/MM/dd")
            }
            val convertedDate = parser.parse(date) as Date

            var formatter = SimpleDateFormat("dd MMM yyyy")
            if (date.endsWith("1") && !date?.endsWith("11"))
                formatter = SimpleDateFormat("d'st', MMM yy")
            else if (date.endsWith("2") && !date?.endsWith("12"))
                formatter = SimpleDateFormat("d'nd', MMM yy")
            else if (date.endsWith("3") && !date?.endsWith("13"))
                formatter = SimpleDateFormat("d'rd', MMM yy")
            else
                formatter = SimpleDateFormat("d'th', MMM yy")

            return formatter.format(convertedDate)
        } else {
            return "Date Not Available"
        }

    }

    fun getFormattedTime(time: String): String {
        val dateFormat = SimpleDateFormat("hh.mm aa")
        val dateString = dateFormat.format(time).toString()
        return dateString
    }

    fun getHomeScreenContentsFromAEM(context: Context): String {
        return getLocalConfigFile(context)
    }
    fun getLocalConfigFile(context: Context): String {
        return loadLocalJsonFile(context, context.getString(R.string.home_seq_local_file_path))
    }
    fun loadLocalJsonFile(context: Context, fileName: String): String {
        var json: String? = null
        try {
            var inputStream = context.assets.open(fileName)
            var size = inputStream.available()
            var buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}