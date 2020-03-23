package com.example.dynamicform.widget_factory

import android.content.Context
import android.view.ViewGroup
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

        val radioButtonsArray = Array(widgetData.options.size) {
            val options = widgetData.options[it]
            RadioButton(context).apply {
                text = options.displayName
                setTag(R.id.key, widgetData.key)
                setTag(R.id.child_key, options.id)

                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setOnCheckedChangeListener(listener)
            }
        }
        radioButtonsArray.forEach { rg.addView(it) }
        viewList.add(rg)
    }

    override fun getWidgets() = viewList
}