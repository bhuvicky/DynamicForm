package com.example.dynamicform.ui

import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton

interface ViewListener: View.OnClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
}