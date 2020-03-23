package com.example.dynamicform.widget_factory

import android.R
import android.content.Context
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import com.example.dynamicform.data.WidgetData
import com.example.dynamicform.ui.ViewListener

class SpinnerWidget(val ctxt: Context, val data: WidgetData, val listener: ViewListener): Widget(ctxt, data) {

    private val spinner by lazy { Spinner(context) }

    init {
        createLabel()

        // Create Spinner
        // Here, we don't need to return anything, so instead of using "apply block", we can use "with block" here, to construct the object.
        with(spinner) {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val arrayAdapter = ArrayAdapter(context, R.layout.simple_spinner_item, widgetData.dropDownList)
            adapter = arrayAdapter
            onItemSelectedListener = listener
        }
        viewList.add(spinner)
    }
    override fun getWidgets() = viewList
}