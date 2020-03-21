package com.example.dynamicform.widget_factory

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.example.dynamicform.data.WidgetData
import com.example.dynamicform.ui.ViewListener
import com.example.dynamicform.utils.ViewUtil

class EdittextWidget(val ctxt: Context, val data: WidgetData, val listener: ViewListener): Widget(ctxt, data) {

    private val editText by lazy { EditText(context) }

    init {
        // Create EditText
        with(editText) {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            hint = widgetData.label
            inputType = ViewUtil.getInputType(widgetData.properties.inputType)
            addTextChangedListener(listener)
        }
        viewList.add(editText)
    }

    override fun getWidgets() = viewList
}