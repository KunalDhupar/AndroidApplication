package com.cg.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }

    fun buttonClick(view: View) {
        val id=view.id
        when(id){
            R.id.btn1 ->{
                Toast.makeText(this,"Clicking Radio Demo Activity",Toast.LENGTH_LONG).show()
                val i=Intent(this,RadioDemo::class.java)
                startActivity(i)
            }
            R.id.btn2 ->{
                Toast.makeText(this,"Clicking  CheckBox Activity",Toast.LENGTH_LONG).show()
                val i=Intent(this,CheckBoxActivity::class.java)
                startActivity(i)
            }
            R.id.btn3->{
                Toast.makeText(this,"Clicking ListView Activity",Toast.LENGTH_LONG).show()
                val i=Intent(this,ListView::class.java)
                startActivity(i)
            }
            R.id.btn4->{
                Toast.makeText(this,"Clicking Spinner Activity",Toast.LENGTH_LONG).show()
                val i=Intent(this,SpinnerActivity::class.java)
                startActivity(i)
            }
            R.id.btn5->{
                Toast.makeText(this,"Clicking Custom Adapter Activity",Toast.LENGTH_LONG).show()
                val i=Intent(this,CustomAdapter::class.java)
                startActivity(i)

            }
        }
    }

    fun fabClciked(view: View) {
        val i=Intent(this,WebView::class.java)
        startActivity(i)

    }
}