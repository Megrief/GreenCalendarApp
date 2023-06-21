package com.example.greencalendar.plants_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.greencalendar.R
import com.example.greencalendar.utils.AgeFormatter
import com.google.android.material.imageview.ShapeableImageView

class PlantCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view), AgeFormatter {
    private val plantsPhoto = view.findViewById<ShapeableImageView>(R.id.plants_photo)
    private val plantsName = view.findViewById<TextView>(R.id.plants_name)
    private val plantsAge = view.findViewById<TextView>(R.id.plants_age)
    private val plantsType = view.findViewById<TextView>(R.id.plants_type)



    fun bind(plant: Plant) {
        Glide.with(view).load(plant.plantsPhotoPath).placeholder(R.drawable.heart_flower).into(plantsPhoto)
        plantsName.text = plant.plantsName
        plantsAge.text = getAge(plant.plantingDate)
        plantsType.text = plant.plantsType
    }


}

