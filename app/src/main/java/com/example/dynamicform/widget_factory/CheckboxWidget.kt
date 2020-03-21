package com.example.dynamicform.widget_factory

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.dynamicform.R
import com.example.dynamicform.data.WidgetData
import com.example.dynamicform.ui.ViewListener


class CheckboxWidget(val ctxt: Context, val data: WidgetData, val listener: ViewListener) :
    Widget(ctxt, data) {

    init {
        createLabel()
        createCheckbox()
    }

    private fun createCheckbox() {
        widgetData.options.forEach {
            with(CheckBox(context)) {
                text = it.displayName
                setTag(R.id.key, widgetData.key)
                setTag(R.id.child_key, it.id)

                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setOnCheckedChangeListener(listener)
                viewList.add(this)
            }
        }
    }

    override fun getWidgets() = viewList
}