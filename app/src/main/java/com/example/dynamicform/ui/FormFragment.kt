package com.example.dynamicform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.dynamicform.R
import com.example.dynamicform.base.BaseFormFragment
import com.example.dynamicform.data.FormPage
import com.example.dynamicform.widget_factory.WidgetFactory

class FormFragment: BaseFormFragment() {

    private lateinit var page: FormPage
    private val viewList by lazy { arrayListOf<View>() }
    private lateinit var rootView: LinearLayout

    companion object {
        fun newInstance(page: FormPage) = FormFragment().apply {
            this.page = page
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_form, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = getView()!!.findViewById<View>(R.id.main_layout) as LinearLayout
        page.widgetData.forEach {
            val widgets = WidgetFactory.getWidget(FormFragment@this.context!!, it, this)
            viewList.addAll(widgets)
        }

        // IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
        viewList.forEach { rootView.addView(it) }
    }
}