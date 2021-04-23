package com.cg.androidui

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_constraint.*

class MainActivity : AppCompatActivity(),
        View.OnClickListener,
        TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        var firsttimeuser=true
        //lateinit var regButton:Button
        //lateinit var msgText:TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_constraint)
        //register for context Menu
        registerForContextMenu(Demo)
        //Dynamic creation of a layout
        /*val parent=LinearLayout(this)
        val tv=TextView(this)
        parent.addView(tv)
        */



        button2.setOnClickListener(this) //register listener
        //button.setOnClickListener(this)
        /*button.setOnClickListener {
            Toast.makeText(it.context,"Through lambda expression: ${it.id}",Toast.LENGTH_LONG).show()
        }*/
        //if first time visit, show both register and sign in, else show message please sign in and show only the sign in button
        //regButton=findViewById(R.id.bt1)
        //msgText=findViewById(R.id.tv2)
        if(!firsttimeuser) {
            //hide register button
            //regButton.visibility= View.GONE
            //msgText.setText("Please Sign-in")
            button.visibility = View.GONE
            textView2.setText("Please Sign-in")
        }

        }
    override fun onClick(v: View) {

        //reaction to click
        when(v.id){
            R.id.button->{
                val t=Toast.makeText(this,"Register Button Clicked",Toast.LENGTH_LONG)
                t.setGravity(Gravity.TOP,20,50)
                t.show()

            }
            R.id.button2->{
                //val t=Toast.makeText(this,"Sign In Button Clicked",Toast.LENGTH_LONG)
                //t.setGravity(Gravity.TOP,20,50)
                //t.show()
                var snack=Snackbar.make(Parent,"Signing in...",Snackbar.LENGTH_INDEFINITE)
                snack.setAction("UNDO",View.OnClickListener {
                    Snackbar.make(Parent,"Action Undone...",Snackbar.LENGTH_LONG).show()
                })
                snack.show()


                val i=Intent(this,Signin::class.java)
                //in java- Intent i=new Intent(this,Signin.class)
                startActivity(i)

            }
            //

        }


    }

    fun RegisterClicked(view: View) {
        /*when(view.id){
            R.id.button->{
                Toast.makeText(this,"Register Button Clicked via Attribute",Toast.LENGTH_LONG).show()
                val j=Intent(this,Register::class.java)
                startActivity(j)
            }
        }
    */
            //show popup menu
        val pmenu=PopupMenu(this,button)
        val menu=pmenu.menu
        menu.add(0,1,0,"Driver")
        menu.add(0,2,0,"Rider")
        pmenu.show()

        pmenu.setOnMenuItemClickListener {
            when(it.itemId){
                1->{
                    Toast.makeText(this,"Register Button Clicked as Driver",Toast.LENGTH_LONG).show()
                    val j=Intent(this,Register::class.java)
                    startActivity(j)
                    true
                }
                else-> {
                    Toast.makeText(this,"Register Button Clicked as Rider",Toast.LENGTH_LONG).show()
                    val j = Intent(this, Register::class.java)
                    startActivity(j)
                    true

                }

            }
        }
    }



    fun Demoactivity(view: View) {
        val act=Intent(this,DemoActivity::class.java)
        startActivity(act)
    }
    val MENU_LOGIN=1
    val MENU_REGISTER=2
    val MENU_EXIT=3//any positive numbers
    val MENU_TIME=4
    val MENU_DATE=5
    val MENU_PROGRESS=6
    val MENU_STOP=7

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val loginItem=menu?.add(0,MENU_LOGIN,0,"LOGIN")
      //  loginItem?.setIcon(android.R.drawable.ic_dialog_info)
        loginItem?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0,MENU_REGISTER,1,"REGISTER")
        menu?.add(0,MENU_EXIT,2,"EXIT")
        menu?.add(0,MENU_TIME,3,"TIME")
        menu?.add(0,MENU_DATE,4,"DATE")
        menu?.add(0,MENU_PROGRESS,5,"START TASK")
        menu?.add(0,MENU_STOP,6,"STOP TASK")
        return super.onCreateOptionsMenu(menu)
    }
    lateinit var pdlg:ProgressDialog
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            MENU_LOGIN->{
                val i=Intent(this,Signin::class.java)
                startActivity(i)
            }
            MENU_REGISTER->{
                val d=MyDialog()
                //put some data in a bundle and send it to dialog
                val bundle=Bundle()
                bundle.putString("msg","Please choose your identity")
                bundle.putString("btn1","Rider")
                bundle.putString("btn2","Driver")
                d.arguments=bundle
                d.show(supportFragmentManager,"abc")
                //val i=Intent(this,Register::class.java)
                //startActivity(i)
                return true
            }
            MENU_EXIT->{
                //finish()
                //displaying dialog

                val d=MyDialog()
                //put some data in a bundle and send it to dialog
                val bundle=Bundle()
                bundle.putString("msg","Do you want to exit")
                bundle.putString("btn1","YES")
                bundle.putString("btn2","NO")
                bundle.putInt("type",1)
                d.arguments=bundle
                d.show(supportFragmentManager,"xyz")
                return true
            }
            MENU_TIME->{
                val dlg=MyDialog()
                val bundle=Bundle()
                bundle.putInt("type",2)
                dlg.arguments=bundle
                dlg.show(supportFragmentManager,"pqr")
            }
            MENU_DATE->{
                val dlg=MyDialog()
                val bundle=Bundle()
                bundle.putInt("type",3)
                dlg.arguments=bundle
                dlg.show(supportFragmentManager,"pqr")
            }
            MENU_PROGRESS->
            {

                //pdlg=ProgressDialog.show(this,"Downloading..","Please wait and dont refresh",true,true)
                progressBar.visibility=View.VISIBLE
                progressBar.progress=30
            }
            MENU_STOP->{//pdlg.cancel()
                //
            progressBar.visibility=View.INVISIBLE
            }

        }
        return super.onOptionsItemSelected(item)
    }
    val MENU_RB=1
    val MENU_CB=2
    val MENU_LV=3
    val MENU_SP=4
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(0,MENU_RB,0,"RADIO BUTTON DEMO")
        menu?.add(0,MENU_CB,1,"CHECK BOX DEMO")
        menu?.add(0,MENU_LV,2,"LIST VIEW DEMO")
        menu?.add(0,MENU_SP,3,"SPINNER DEMO")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        lateinit var i:Intent
        when(item.itemId){
            MENU_RB->{
                i= Intent(this,RadioDemo::class.java)

            }
            MENU_CB->{
                i=Intent(this,CheckBoxActivity::class.java)
            }
            MENU_LV->{
                i=Intent(this,ListView::class.java)
            }
            MENU_SP->{
                i=Intent(this,SpinnerActivity::class.java)
            }
        }
        startActivity(i)
        return true
        return super.onContextItemSelected(item)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Toast.makeText(this,"Time: $p1 hrs $p2 min",Toast.LENGTH_LONG).show()
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(this,"Date is $p3-$p2-$p1",Toast.LENGTH_LONG).show()
    }
}

