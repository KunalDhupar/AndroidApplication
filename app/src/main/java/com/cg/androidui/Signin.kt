package com.cg.androidui

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity() {
    val isdataentered=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        //setting uid on create
        name.setText("Kunal", TextView.BufferType.NORMAL)
    }

    fun Signing(view: View) {
        when (view.id) {
            R.id.signin -> {
                val uid=name.text.toString()
                val pas=password.text.toString()
                if(uid.isNotEmpty() && pas.length>8)
                    Toast.makeText(this, "Welcome user ${uid}", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"Please enter correct uid or password",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val nManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.cancel(1)

    }

    override fun onPause() {
        super.onPause()
        if(!isdataentered)
            sendNotification()

    }
    //above oreo(8.0)-Notification to be delievered via a channel
    private fun sendNotification(){
        //1.Get refernce from Notification manager
        val nManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //NotificationManager nManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)


        //2. create notification
        lateinit var builder:Notification.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("test", "KunalDhuparApp", NotificationManager.IMPORTANCE_DEFAULT)
            nManager.createNotificationChannel(channel)
            builder=Notification.Builder(this,"test")
        }
        else {
             builder = Notification.Builder(this)
        }
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("Authentication")
        builder.setContentText("Please Complete Signing in")
        builder.setAutoCancel(true)
        val tryIntent=Intent(this,MainActivity::class.java)
        val resumeIntent=PendingIntent.getActivity(this,0,tryIntent,0)

        val resumeAction =Notification.Action.Builder(android.R.drawable.ic_dialog_info,"Try Again",resumeIntent).build()
        builder.addAction(resumeAction)
        val l=layoutInflater.inflate(R.layout.activity_main,null)
        //create remote view
        //set remote view
        //builder.setCustomContentView()
        val intent= Intent(this,Signin::class.java)
        val pi=PendingIntent.getActivity(this,  0,intent,0)
        builder.setContentIntent(pi)

        val myNotification=builder.build()

        //myNotification.flags=Notification.FLAG_AUTO_CANCEL or Notification.FLAG_NO_CLEAR


        //3.send notification
        nManager.notify(1,myNotification)
    }

    fun goback(view: View) {
        when(view.id){
            R.id.cancel->{
                Toast.makeText(this,"Going back to the home page",Toast.LENGTH_LONG).show()
                Thread.sleep(1000)
                finish()
            }
        }
    }
}

