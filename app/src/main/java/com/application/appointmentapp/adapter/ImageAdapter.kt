package com.application.appointmentapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.application.appointmentapp.R
import com.application.appointmentapp.Router
import com.application.appointmentapp.model.HomeGridItem
import kotlinx.android.synthetic.main.home_grid.view.*


class ImageAdapter(private val homeItemList: ArrayList<HomeGridItem>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater =
            parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.home_grid, parent, false)

        val title = view.findViewById<TextView>(R.id.txt_title)
        val icon = view.findViewById<ImageView>(R.id.img_icon)

        title.text = homeItemList[position].title
        icon.setImageResource(homeItemList[position].img)

        view.cardView.setOnClickListener {
            Router().startShowPackageActivity(view.context, homeItemList[position].title)
        }
        return view
    }

    override fun getItem(position: Int): Any? {
        return homeItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return homeItemList.size
    }
}