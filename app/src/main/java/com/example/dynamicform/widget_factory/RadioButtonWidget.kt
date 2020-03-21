package com.example.dynamicform.widget_factory

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.dynamicform.R
import com.example.dynamicform.data.WidgetData
import com.example.dynamicform.ui.ViewListener

class RadioButtonWidget(val ctxt: Context, val data: WidgetData, val listener: ViewListener) :
    Widget(ctxt, data) {


    init {
        createLabel()
        createRadioGroup()
    }

    private fun createRadioGroup() {
        // create a radio group
        val rg = RadioGroup(context)
        rg.orientation = RadioGroup.VERTICAL

        widgetData.options.forEach {
            with(RadioButton(context)) {
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