package com.application.appointmentapp

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BookFragment : androidx.fragment.app.Fragment() {

    lateinit var database: SQLiteDatabase
    var name = ""
    var number = ""
    var info = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (!(savedInstanceState?.isEmpty!!)) {
            name = savedInstanceState.getString("name").toString()
            number = savedInstanceState.getString("number").toString()
            info = savedInstanceState.getString("info").toString()
        }

    }
}
