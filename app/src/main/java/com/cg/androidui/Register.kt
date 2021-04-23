package com.cg.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_signin.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun Canceling(view: View) {
        Toast.makeText(this,"Going back to the home page", Toast.LENGTH_LONG).show()
        Thread.sleep(1000)
        finish()
    }
    fun Registering(view: View) {
        val uid=Ename.text.toString()
        val post=postadd.text.toString()
        if (uid.isEmpty())
            Toast.makeText(this, "Please Enter your name!", Toast.LENGTH_LONG).show()
        if(post.length!=6)
            Toast.makeText(this, "Please enter the correct postal code", Toast.LENGTH_LONG).show()

    }
}