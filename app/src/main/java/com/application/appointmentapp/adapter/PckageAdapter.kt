package com.application.appointmentapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.appointmentapp.R
import com.application.appointmentapp.Router
import com.application.appointmentapp.model.PackageModel
import kotlinx.android.synthetic.main.pckage_list_layout.view.*

class PckageAdapter(private val homeItemList: ArrayList<PackageModel>) :
    RecyclerView.Adapter<PckageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.pckage_list_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(homeItemList[position])

    }

    override fun getItemCount(): Int {
        return homeItemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(packageModel: PackageModel) {

            itemView.txt_package_name.text = packageModel.pkgName
            itemView.txt_package_price.text = packageModel.price
            itemView.txt_package_info.text = packageModel.info
            itemView.btn_book.setOnClickListener {
                Router().startBookAppointmentActivity(itemView.context, null)
            }
        }
    }
}