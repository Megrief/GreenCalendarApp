package com.example.greencalendar.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.greencalendar.R

class MainActivity : AppCompatActivity() {
    private val calendar by lazy { findViewById<LinearLayoutCompat>(R.id.calendar) }
    private val plants by lazy { findViewById<LinearLayoutCompat>(R.id.plants) }
    private val useful by lazy { findViewById<LinearLayoutCompat>(R.id.useful) }
    private val chat by lazy { findViewById<LinearLayoutCompat>(R.id.chat) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        calendar.start(CalendarActivity())

        plants.start(MyPlantsActivity())

        useful.move(Uri.parse("https://t.me/tcvety_doma"))

        chat.move(Uri.parse("https://t.me/tcvety_doma1"))

    }

    private fun View.move(uri: Uri) {
        this.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }

    private fun View.start(activity: AppCompatActivity) {
        this.setOnClickListener {
            startActivity(Intent(this@MainActivity, activity::class.java))
        }
    }
}