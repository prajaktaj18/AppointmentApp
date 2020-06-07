package com.application.appointmentapp

import android.os.Bundle
import android.text.Html
import android.widget.GridView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.application.appointmentapp.adapter.ImageAdapter
import com.application.appointmentapp.model.HomeGridItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_drawer_header_item.view.*

class HomeActivity : AppCompatActivity() {

    val homeItemList: ArrayList<HomeGridItem> = ArrayList()
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        homeItemList.add(HomeGridItem(getString(R.string.hair_cut), R.drawable.ic_hair_cut))
        homeItemList.add(HomeGridItem(getString(R.string.spa), R.drawable.ic_spa))
        homeItemList.add(HomeGridItem(getString(R.string.hair_color), R.drawable.ic_hair_dye))
        homeItemList.add(HomeGridItem(getString(R.string.make_up), R.drawable.ic_make_up))
        homeItemList.add(HomeGridItem(getString(R.string.facial), R.drawable.ic_facial))
        homeItemList.add(HomeGridItem(getString(R.string.bridal), R.drawable.ic_bridal))

        gridview.adapter = ImageAdapter(homeItemList)

        // Configure the grid view
        gridview.numColumns = 2
        gridview.horizontalSpacing = 15
        gridview.verticalSpacing = 15
        gridview.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        txt_info.text = Html.fromHtml(getString(R.string.about_info))

        book_appointment.nav_title.text = getString(R.string.book_appointment)
        show_pkg.nav_title.text = getString(R.string.show_pkg)
        appointment_history.nav_title.text = getString(R.string.appointment_history)

        book_appointment.setOnClickListener {
            Router().startBookAppointmentActivity(this, null)
        }
        appointment_history.setOnClickListener {
            Router().startAppointmentHistoryActivity(this)
        }
        show_pkg.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        img_nav_close.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        img_hamburger.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        fab.setOnClickListener {
            Router().startBookAppointmentActivity(this, null)
        }
    }
}