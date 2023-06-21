package com.example.greencalendar.utils

import android.view.View

class Container {
    private val content: MutableMap<String, View> = mutableMapOf()

    fun init(key: String, view: View): View {
        content[key] = view
        return view
    }

    fun getView(key: String): View? = content[key]

}