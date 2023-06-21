package com.example.greencalendar.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.core.view.updateLayoutParams
import com.example.greencalendar.R
import com.example.greencalendar.plants_list.Plant
import com.example.greencalendar.utils.Container
import com.google.android.material.imageview.ShapeableImageView
import com.google.gson.Gson
import java.time.LocalDate

class PlantPassportActivity : AppCompatActivity() {
    private val back by lazy { findViewById<ShapeableImageView>(R.id.back) }
    private val apply by lazy { findViewById<ShapeableImageView>(R.id.apply) }
    private val edit by lazy { findViewById<ShapeableImageView>(R.id.edit) }
    private val plantsPhoto by lazy { findViewById<ShapeableImageView>(R.id.plants_photo) }
    private val paramGroup by lazy { findViewById<Group>(R.id.param_group) }
    private val paramContainer by lazy {
        Container().apply {
            init("name", findViewById(R.id.name_value))
            init("age", findViewById(R.id.age_value))
            init("type", findViewById(R.id.type_value))
            init("watering", findViewById(R.id.watering_value))
        }
    }
    private val editParamGroup by lazy { findViewById<Group>(R.id.edit_param_group) }
    private val editorsContainer by lazy {
        Container().apply {
            init("name", findViewById(R.id.edit_name))
            init("age", findViewById(R.id.edit_planting_date))
            init("type", findViewById(R.id.edit_type))
            init("watering", findViewById(R.id.edit_watering))
        }
    }
    private val addButton by lazy { findViewById<ShapeableImageView>(R.id.add_event) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_passport)

        val plant = savedInstanceState?.getString("PLANT_VALUE", null)?.let {
            Gson().fromJson(it, Plant::class.java)
        } ?: Plant("", LocalDate.now(), "", "", "")

        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    private fun editModeOn() {
        edit.setOnClickListener {
            addButton.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToBottom = findViewById<Barrier>(R.id.events_barrier).id
            }
        }

    }
    private fun bind(plant: Plant) {

    }

}