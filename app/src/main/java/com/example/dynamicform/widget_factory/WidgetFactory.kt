package com.example.dynamicform.widget_factory

import android.content.Context
import com.example.dynamicform.data.WidgetData
import com.example.dynamicform.ui.ViewListener

object WidgetFactory {

    fun getWidget(context: Context, widgetData: WidgetData, listener: ViewListener) =
        when(widgetData.displayType) {
            "edit_text" -> EdittextWidget(context, widgetData, listener).getWidgets()
            "dropdown" -> SpinnerWidget(context, widgetData, listener).getWidgets()
            "radio_group" -> RadioButtonWidget(context, widgetData, listener).getWidgets()
            else -> CheckboxWidget(context, widgetData, listener).getWidgets()
        }
}