package com.example.greencalendar.enums

enum class Watering(private val value: String) {
    SELDOM("Редко"),
    MEDIUM("Умеренно"),
    OFTEN("Часто")
    ;

    override fun toString() = value
}