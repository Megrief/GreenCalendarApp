package com.example.greencalendar.plants_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greencalendar.R

class PlantCardAdapter(private val plantsList: List<Plant>, val onItemClick: (Plant) -> Unit) : RecyclerView.Adapter<PlantCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantCardViewHolder {
        return PlantCardViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.plant_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return plantsList.size
    }

    override fun onBindViewHolder(holder: PlantCardViewHolder, position: Int) {
        val plant = plantsList[position]
        holder.bind(plant)
        holder.itemView.setOnClickListener { onItemClick(plant) }

    }
}