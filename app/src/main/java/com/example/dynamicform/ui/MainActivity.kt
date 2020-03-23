package com.example.dynamicform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicform.R
import com.example.dynamicform.data.FormPage
import com.example.dynamicform.utils.FileUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val fm = supportFragmentManager
    private lateinit var pageList: List<FormPage>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        FileUtil.getAssetJsonData(this, "form.json") {
            pageList = it
            doFragmentTransaction()
        }
        setListeners()
    }

    private fun setListeners() {
        buttonNext.setOnClickListener {
            if (fm.backStackEntryCount == pageList.size - 1)
                buttonNext.text = "Submit"
            if (fm.backStackEntryCount <= pageList.size - 1)
                doFragmentTransaction()
        }

        buttonPrevious.setOnClickListener {
            buttonNext.text = "Next"
            onBackPressed()
        }
    }

    private fun doFragmentTransaction() {
        fm.beginTransaction().add(
            R.id.fragment_container,
            FormFragment.newInstance(pageList.get(fm.backStackEntryCount))
        ).addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        if (fm.backStackEntryCount > 1)
            fm.popBackStack()
    }
}
