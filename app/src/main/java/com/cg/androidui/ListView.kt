package com.cg.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity(), AdapterView.OnItemClickListener {
    val langList= mutableListOf<String>("Kotlin","Python","JAVA",
        "C++","Swift","SQL","CSS","JavaScript","R","C#","Dart","React","PHP","Jquery","HTML")
    lateinit var  adapter:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        //Adapter- 1.supplying data to the view
        // 2. Defines the layout of each item
        /*
        listview,spinner,recycleview->AdapterViews
        1.Array Adapter
        2.Cursor Adapter
        3.Custom Adapter
         */
         adapter=ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, langList)
            //list_item can be rerendered each time a new item is detected
        lv.adapter=adapter //data bounded here
        lv.setOnItemClickListener(this)



    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
        val selectedItem=langList[index]
        Toast.makeText(this,"Selected Item: $selectedItem",Toast.LENGTH_LONG).show()
        langList.removeAt(index) //remove selected item
        //rerender the new updated list

    }
}