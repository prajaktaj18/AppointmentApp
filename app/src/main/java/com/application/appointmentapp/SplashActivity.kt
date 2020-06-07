package com.application.appointmentapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Hiding Title bar of this activity screen */
        window.requestFeature(Window.FEATURE_NO_TITLE)

        /** Making this activity, full screen */
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        setUI()
        Handler().postDelayed({
            val it = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(it)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    private fun setUI() {
        txt_name.text = Html.fromHtml(getString(R.string.splash_global_beauty))
    }

    companion object {

        private val SPLASH_TIME_OUT = 5000
    }
}