package com.application.appointmentapp

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.appointmentapp.adapter.HistoryAdapter
import kotlinx.android.synthetic.main.actionbar_header.*
import kotlinx.android.synthetic.main.activity_appointment_history.*
import java.util.*

class AppointmentHistoryActivity : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var cursor: Cursor
    lateinit var myHelper: Helper
    private var nameArrayList = ArrayList<String>()
    private var phoneArrayList = ArrayList<String>()
    private var dateArrayList = ArrayList<String>()
    private var timeArrayList = ArrayList<String>()
    private var infoArrayList = ArrayList<String>()
    private var packageArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_history)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recycler_view.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?


        btn_back.setOnClickListener { finish() }
        toolbar_title.text = getString(R.string.appointment_history)

        myHelper = Helper(this, "appointmentdb", null, 1)
        db = myHelper.readableDatabase
        cursor = db.rawQuery("select * from user_data", null)

        if (cursor.moveToFirst()) {
            do {
                nameArrayList.add(cursor.getString(cursor.getColumnIndex("name")))
                phoneArrayList.add(cursor.getString(cursor.getColumnIndex("num")))
                infoArrayList.add(cursor.getString(cursor.getColumnIndex("info")))
                timeArrayList.add(cursor.getString(cursor.getColumnIndex("time")))
                dateArrayList.add(cursor.getString(cursor.getColumnIndex("date")))
                packageArrayList.add(cursor.getString(cursor.getColumnIndex("package")))

            } while (cursor.moveToNext())
        }
        if (nameArrayList.isNullOrEmpty()) {
            txt_no_data.visibility = View.VISIBLE
            recycler_view.visibility = View.GONE
        } else {
            txt_no_data.visibility = View.GONE
            recycler_view.visibility = View.VISIBLE
            val users = ArrayList<User>()
            for (item in 0 until nameArrayList.size) {
                users.add(
                    User(
                        nameArrayList[item],
                        phoneArrayList[item],
                        infoArrayList[item],
                        timeArrayList[item],
                        dateArrayList[item],
                        packageArrayList[item]
                    )
                )
            }
            val adapter =
                HistoryAdapter(users)
            recycler_view.adapter = adapter
        }
    }
}
