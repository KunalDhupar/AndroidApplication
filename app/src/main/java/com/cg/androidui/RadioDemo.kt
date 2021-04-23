package com.cg.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class RadioDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_demo)
    }

    fun isChecked(view: View) {
        if (view is RadioButton){
            val isChecked=view.isChecked
            if(isChecked){
                var selcity=view.text.toString()
                Toast.makeText(this,"You selected: $selcity",Toast.LENGTH_LONG).show()
            }
        }
    }

}