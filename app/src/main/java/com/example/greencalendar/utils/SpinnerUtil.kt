package com.example.greencalendar.utils

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.greencalendar.R

class SpinnerUtil<T>(
    array: Array<T>,
    context: Context,
    private val spinner: Spinner,
    private val onSelect: (T) -> Unit,
    private val onLongClick: (T) -> Unit
) : AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener {
    init {

        ArrayAdapter(context, R.layout.spinner_item, array).also {
            it.setDropDownViewResource(R.layout.spinner)
            spinner.adapter = it
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)?.let {
            onSelect(it as T)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) { }

    @Suppress("UNCHECKED_CAST")
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        return if (parent != null) {
            parent.getItemAtPosition(position)?.let {
                onLongClick(it as T)
            }
            true
        } else false
    }
}