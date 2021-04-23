package com.cg.androidui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_adapter.*
import kotlinx.android.synthetic.main.student_list_item.*
import java.security.AccessControlContext

class CustomAdapter : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var adapter:StudentAdapter
    var studentList= mutableListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter)
        studentList.add(Student("Kunal",1,93.8))
        studentList.add(Student("Arjun",2,90.8))
        studentList.add(Student("Anurag",3,88.8))
        studentList.add(Student("Jay",4,89.9))
        studentList.add(Student("Jai",5,89.9))
        studentList.add(Student("Jatin",6,89.9))
        studentList.add(Student("Aman",7,89.9))
        val adapter=StudentAdapter(this,R.layout.student_list_item,studentList)
        studList.adapter=adapter
        studList.setOnItemClickListener(this)





    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
        var std=studentList[index]
        //alternativiely

        Toast.makeText(this,"Name:${std.name} rno:${std.rno} %age:${std.percent}",Toast.LENGTH_LONG).show()

    }

}
data class Student(val name:String,val rno:Int,val percent:Double)

class StudentAdapter(context: Context,val layoutRes:Int,val data:List<Student>):ArrayAdapter<Student>(context,layoutRes,data){
    override fun getItem(position: Int): Student? {
        return data[position]
    }
    //create view and bind data to it
    //gets called as many times as no. of elements
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val student=getItem(position)
        //view Creation-make it conditional-if view is already created
        /*
        lateinit var view: View
        if(convertView!=null)
                view=LayoutInflater.from(context).inflate(layoutRes,null)
        else
                view=convertView!!
        */
        val view=convertView?:LayoutInflater.from(context).inflate(layoutRes,null)
        //bind data appropiately
        val nameT=view.findViewById<TextView>(R.id.nameT)
        val rollT=view.findViewById<TextView>(R.id.rollT)
        val perT=view.findViewById<TextView>(R.id.perT)
        nameT.text=student?.name
        rollT.text="${student?.rno}"
        perT.text="${student?.percent}"
        return view
    }


}