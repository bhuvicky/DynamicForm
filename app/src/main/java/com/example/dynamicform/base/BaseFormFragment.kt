package com.example.dynamicform.base

import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.example.dynamicform.ui.ViewListener

open class BaseFormFragment: Fragment(), ViewListener {

    override fun onClick(v: View?) {
        
    }

    override fun afterTextChanged(s: Editable?) {
        
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (position > 0) {
            val answer = parent?.getItemAtPosition(position + 1) as String
        }
    }
}