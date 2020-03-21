package com.example.dynamicform.widget_factory

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import com.example.dynamicform.data.WidgetData

abstract class Widget(val context: Context, val widgetData: WidgetData) {

    protected val viewList by lazy { arrayListOf<View>() }

    fun createLabel() {
        with(TextView(context)) {
            textSize = 16f
            text = widgetData.label
            typeface = Typeface.DEFAULT_BOLD

            viewList.add(this)
        }
    }

    abstract fun getWidgets(): List<View>
}