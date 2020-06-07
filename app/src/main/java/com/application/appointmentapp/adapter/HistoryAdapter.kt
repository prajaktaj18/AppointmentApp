package com.application.appointmentapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.appointmentapp.R
import com.application.appointmentapp.User
import kotlinx.android.synthetic.main.history_list_layout.view.*

class HistoryAdapter(val appointmentList: ArrayList<User>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.history_list_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(appointmentList[position])

    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User) {

            itemView.txt_name.text = user.name
            itemView.txt_no.text = user.contactNumber
            if (user.info == "")
                itemView.txt_info.visibility = View.GONE
            else {
                itemView.txt_info.visibility = View.VISIBLE
                itemView.txt_info.text = user.info
            }
            itemView.txt_time.text = user.time
            itemView.txt_date.text = user.date
//            if (appointmentList.isNullOrEmpty())
//                itemView.txt_package_info.text = user.packageSelected
//            else
//                itemView.txt_package_info.text = ", " + user.packageSelected
        }
    }
}