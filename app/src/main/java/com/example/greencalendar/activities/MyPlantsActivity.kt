package com.example.greencalendar.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.greencalendar.R
import com.example.greencalendar.plants_list.Plant
import com.example.greencalendar.plants_list.PlantCardAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.google.gson.Gson
import java.time.LocalDate

class MyPlantsActivity : AppCompatActivity() {
    private val plantsList by lazy { findViewById<RecyclerView>(R.id.plants_list) }
    private val back by lazy { findViewById<ShapeableImageView>(R.id.back) }
    private val add by lazy { findViewById<ShapeableImageView>(R.id.add_event) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_plants)
        organizeList()


        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        add.setOnClickListener {
            startActivity(Intent(this, PlantPassportActivity::class.java))
        }

    }

    private fun organizeList() {
        plantsList.adapter = PlantCardAdapter(mockPlantsList) {
            val toJ = Gson().toJson(it, Plant::class.java)
            startActivity(Intent(this, PlantPassportActivity::class.java)
                .putExtra("PLANT_VALUE", toJ))
        }
    }
    companion object {
        val mockPlantsList = listOf<Plant>(
            Plant(
                "Гоша",
                LocalDate.of(2013, 10, 3),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg",
                ""
            ),
            Plant(
                "Алёна",
                LocalDate.of(2004, 1, 13),
                "Пальма",
                "https://i.ytimg.com/vi/eXqt78dsWDs/hqdefault.jpg"
            ),
            Plant(
                "Игорь",
                LocalDate.of(2019, 8, 5),
                "Волшебный кактус",
                "https://cvetoshki.ru/wp-content/uploads/2017/10/0110w-14.jpg"
            ),
            Plant(
                "Кристина",
                LocalDate.of(1994, 2, 5),
                "Алоэ",
                "https://tatianakasumova.ru/wp-content/uploads/2019/03/hqdefault.jpg"
            ),
            Plant(
                "Гоша",
                LocalDate.of(1945, 3, 12),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg"
            ),
            Plant(
                "Гоша",
                LocalDate.of(2013, 10, 3),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg",
                ""
            ),
            Plant(
                "Алёна",
                LocalDate.of(2004, 1, 13),
                "Пальма",
                "https://i.ytimg.com/vi/eXqt78dsWDs/hqdefault.jpg"
            ),
            Plant(
                "Игорь",
                LocalDate.of(2019, 8, 5),
                "Волшебный кактус",
                "https://cvetoshki.ru/wp-content/uploads/2017/10/0110w-14.jpg"
            ),
            Plant(
                "Кристина",
                LocalDate.of(1994, 2, 5),
                "Алоэ",
                "https://tatianakasumova.ru/wp-content/uploads/2019/03/hqdefault.jpg"
            ),
            Plant(
                "Гоша",
                LocalDate.of(1945, 3, 12),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg"
            ),
            Plant(
                "Гоша",
                LocalDate.of(2013, 10, 3),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg",
                ""
            ),
            Plant(
                "Алёна",
                LocalDate.of(2004, 1, 13),
                "Пальма",
                "https://i.ytimg.com/vi/eXqt78dsWDs/hqdefault.jpg"
            ),
            Plant(
                "Игорь",
                LocalDate.of(2019, 8, 5),
                "Волшебный кактус",
                "https://cvetoshki.ru/wp-content/uploads/2017/10/0110w-14.jpg"
            ),
            Plant(
                "Кристина",
                LocalDate.of(1994, 2, 5),
                "Алоэ",
                "https://tatianakasumova.ru/wp-content/uploads/2019/03/hqdefault.jpg"
            ),
            Plant(
                "Гоша",
                LocalDate.of(1945, 3, 12),
                "Фикус",
                "https://60.img.avito.st/640x480/7864488160.jpg"
            )
        )

    }
}