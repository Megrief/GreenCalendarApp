package com.example.greencalendar.utils

import java.time.LocalDate
import java.time.Period

interface AgeFormatter {

    fun getAge(plantingDate: LocalDate): String {
        return Period.between(plantingDate, LocalDate.now()).let {
            buildString {
                append(if (it.years != 0) buildAgeString(TimeUnit.YEAR, it.years) + " " else "")
                append(if (it.months - 1 > 0) {
                    buildAgeString(TimeUnit.MONTH, it.months - 1) + " "
                } else if (it.months <= 0) {
                    buildAgeString(TimeUnit.MONTH, 11) + " "
                } else "")
                append(if (it.days != 0) buildAgeString(TimeUnit.DAY, it.days) else "")
            }
        }
    }

    private fun buildAgeString(type: TimeUnit, value: Int): String {
        return value.toString().let {
            when {
                it.matches(Regex("[023456789]*1")) -> "$value ${ type.getUnit(0) }"
                it.matches(Regex("\\d*[234]"))
                        && !it.matches(Regex("\\d*1\\d")) -> "$value ${ type.getUnit(1) }"
                else -> "$value ${ type.getUnit(2) }"
            }
        }
    }

    private enum class TimeUnit(private val list: List<String>) {
        YEAR(listOf("год", "года", "лет")),
        MONTH(listOf("месяц", "месяца", "месяцев")),
        DAY(listOf("день", "дня", "дней"))
        ;
        fun getUnit(position: Int): String {
            return list[position]
        }
    }
}