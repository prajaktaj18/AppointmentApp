package com.application.appointmentapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.actionbar_header.view.*
import kotlinx.android.synthetic.main.activity_book_appointment.*
import kotlinx.android.synthetic.main.dialog_success.view.*
import kotlinx.android.synthetic.main.package_grid.view.*
import java.text.SimpleDateFormat
import java.util.*


class BookAppointmentActivity : AppCompatActivity() {

    private val mobilePattern = "[0-9]{10}"
    var dbDate: String = ""
    lateinit var database: SQLiteDatabase
    lateinit var name: String
    lateinit var number: String
    lateinit var info: String
    lateinit var time: String
    lateinit var packageSelected: String
    lateinit var appointmentDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        setUI()
    }

    private fun setUI() {


        toolbar.toolbar_title.text = getString(R.string.book_appointment)

        toolbar.btn_back.setOnClickListener {
            onBackPressed()
        }

        img_picker.setOnClickListener {
            if (ll_appointment.visibility == View.INVISIBLE) {
                ll_appointment.visibility = View.VISIBLE
                pickDateTime()
            } else
                pickDateTime()
        }

        setPackageList()

        btn_book_appointment.setOnClickListener {
            name = edt_name.text.toString()
            number = edt_number.text.toString()
            info = edt_additional_info.text.toString()
            time = txt_time.text.toString()
            appointmentDate = txt_day_date.text.toString()
            if (isAvailableToBook()) {
                val string =
                    "insert into user_data values('$name','$number','$info','$time','$dbDate','$packageSelected')"
                database.execSQL(string)
                showSuccessAlert()
            } else {
                Toast.makeText(this, "Please fill all the information..!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val ob = Helper(this, "appointmentdb", null, 1)
        database = ob.writableDatabase

    }

    private fun setPackageList() {
        var checkedText = ""
        cb_hair_cut.itemCheckBox.text = getString(R.string.hair_cut)
        cb_spa.itemCheckBox.text = getString(R.string.spa)
        cb_hair_color.itemCheckBox.text = getString(R.string.hair_color)
        cb_make_up.itemCheckBox.text = getString(R.string.make_up)
        cb_facial.itemCheckBox.text = getString(R.string.facial)
        cb_bridal.itemCheckBox.text = getString(R.string.bridal)
        cb_hair_cut.itemCheckBox.isChecked = true

        if (cb_spa.itemCheckBox.isChecked)
            checkedText += getString(R.string.spa)
        else if (cb_hair_color.itemCheckBox.isChecked)
            checkedText += getString(R.string.hair_color)
        else if (cb_make_up.itemCheckBox.isChecked)
            checkedText += getString(R.string.make_up)
        else if (cb_facial.itemCheckBox.isChecked)
            checkedText += getString(R.string.facial)
        else if (cb_bridal.itemCheckBox.isChecked)
            checkedText += getString(R.string.bridal)
        else
            checkedText += getString(R.string.hair_cut)

        packageSelected = checkedText
    }

    private fun showSuccessAlert() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView =
            LayoutInflater.from(this).inflate(R.layout.dialog_success, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        dialogView.txt_username.text = "Hi, " + name
        dialogView.txt_time.text = time
        dialogView.txt_day_date.text = appointmentDate
        val alertDialog = builder.create()
        dialogView.btn_ok.setOnClickListener {
            alertDialog.dismiss()
            finish()
        }

        alertDialog.show()
    }

    private fun isAvailableToBook(): Boolean {
        var name = edt_name.text.toString()
        var number = edt_number.text.toString()
        if (name.isNullOrEmpty()) {
            edt_name.error = "Enter name..!!"
            return false
        } else if (!number.matches(mobilePattern.toRegex())) {
            edt_number.error = "Enter valid phone number..!!"
            return false
        } else if (txt_time.length() == 0) {
            Toast.makeText(this, "Please pick time for the appointment", Toast.LENGTH_SHORT).show()
            return false
        } else if (txt_day_date.length() == 0) {
            Toast.makeText(this, "Please pick date for the appointment", Toast.LENGTH_SHORT).show()
            return false
        } else
            return true
    }

    private fun pickDateTime() {
        val c = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)
        val mHour = c.get(Calendar.HOUR_OF_DAY)
        val mMinute = c.get(Calendar.MINUTE)


        val datePickerDialog = this.let {
            DatePickerDialog(
                it,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val simpledateformat = SimpleDateFormat("EEEE")
                    val date = Date(year, monthOfYear, dayOfMonth - 1)
                    val dayOfWeek = simpledateformat.format(date)
                    txt_day_date.text =
                        Utility().getDate(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString()) + "\n" + dayOfWeek
                    dbDate =
                        Utility().getDate(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
                    getTime(mHour, mMinute)
                }, mYear, mMonth, mDay
            )
        }
        datePickerDialog.show()
    }

    fun getTime(mHour: Int, mMinute: Int) {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                showFormattedTime(hourOfDay, minute)
            }, mHour, mMinute, false
        )
        timePickerDialog.show()
    }

    private fun showFormattedTime(hour: Int, min: Int) {
        var format = ""
        var newHour = hour
        if (newHour == 0) {
            newHour += 12;
            format = " AM"
        } else if (hour == 12) {
            format = " PM"
        } else if (hour > 12) {
            newHour -= 12
            format = " PM"
        } else {
            format = " AM"
        }
        txt_time.text = newHour.toString() + " : " + min.toString() + format
    }
}
