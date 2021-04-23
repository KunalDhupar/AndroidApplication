package com.cg.androidui

import android.app.*
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class MyDialog:DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?):Dialog {

        lateinit var dlg: Dialog
        val parent = activity!!
        val bundle = arguments
        val message = bundle?.getString("msg")
        val btn1 = bundle?.getString("btn1")
        val btn2 = bundle?.getString("btn2")
        val dtype = bundle?.getInt("type")
        val builder = AlertDialog.Builder(parent)
        //builder.setView(R.layout.activity_main)->Activity inside a dialog
        when (dtype) {
            1 -> {
                builder.setTitle("Confirmation?")
                builder.setMessage(message)
                builder.setPositiveButton(btn1, DialogInterface.OnClickListener { dialogInterface, i ->
                    parent.finish()
                })
                builder.setNegativeButton(btn2, DialogInterface.OnClickListener { dlg, i -> //also works
                    dlg.cancel()
                })
                builder.setNeutralButton("Cancel") { dlg, i ->
                    dlg.cancel()
                }
                dlg = builder.create()

            }
            2 -> dlg = TimePickerDialog(parent, parent as TimePickerDialog.OnTimeSetListener,
                    12, 0, false)
            3 -> {
                val calendar=Calendar.getInstance()
                dlg=DatePickerDialog(parent,parent as DatePickerDialog.OnDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
            }
        }
        return dlg
    }
}