package com.cg.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {
    val langList= mutableListOf<String>("Kotlin","Python","JAVA",
        "C++","Swift","SQL","CSS","JavaScript","R","C#","Dart","React","PHP","Jquery","HTML")
    lateinit var  adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, langList)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }


}