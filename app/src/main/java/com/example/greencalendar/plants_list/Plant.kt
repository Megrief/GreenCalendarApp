package com.example.greencalendar.plants_list

import com.example.greencalendar.utils.AgeFormatter
import java.time.LocalDate

data class Plant(
    var plantsName: String,
    var plantingDate: LocalDate, // DD-MM-YYYY get input and then parse it to the suitable format
    var plantsType: String,
    var plantsPhotoPath: String, // Path for importing with Glide
    var wateringFrequency: String = ""
) : AgeFormatter