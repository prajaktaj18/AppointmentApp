package com.application.appointmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.appointmentapp.adapter.PckageAdapter
import com.application.appointmentapp.model.PackageModel
import kotlinx.android.synthetic.main.actionbar_header.*
import kotlinx.android.synthetic.main.activity_show_package.*


class ShowPackageActivity : AppCompatActivity() {
    var packageData = ArrayList<PackageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_package)
        setupView(savedInstanceState)
    }

    private fun setupView(arguments: Bundle?) {

        val categoryTitle = intent.extras?.getString("category")
        btn_back.setOnClickListener { finish() }
        toolbar_title.text = categoryTitle

        if (categoryTitle == getString(R.string.hair_cut))
            packageData = PackageListGenrator().getHairCutData(this)
        else if (categoryTitle == getString(R.string.spa))
            packageData = PackageListGenrator().getSpaData(this)
        else if (categoryTitle == getString(R.string.hair_color))
            packageData = PackageListGenrator().getHairColorData(this)
        else if (categoryTitle == getString(R.string.make_up))
            packageData = PackageListGenrator().getMakeupData(this)
        else if (categoryTitle == getString(R.string.facial))
            packageData = PackageListGenrator().getFacialData(this)
        else if (categoryTitle == getString(R.string.bridal))
            packageData = PackageListGenrator().getBridalData(this)

        recycler_view_package.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
        val adapter = PckageAdapter(packageData)
        recycler_view_package.smoothScrollToPosition(0)
        recycler_view_package.adapter = adapter
    }
}