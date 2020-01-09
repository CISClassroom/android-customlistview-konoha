package com.cis.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("OOP","JAVA","KOTLIN"

        )
        val student_name = resources.getStringArray(R.array.student_name)

        //data DB ->Adapter ->,Listview //แปลงจาก Adapterมาที่Listview
        val mylistview = findViewById<ListView>(R.id.mylistview) //val is datatype

        val arrayAdapter: ArrayAdapter<*> //เอาชื่อคลาสมาเป็นตัวแปร
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,student_name)
        mylistview.adapter = arrayAdapter as ListAdapter
        mylistview.setOnItemClickListener { parent, view, position, id ->
            Log.i("listview item", position.toString())
            //get text from listview by position
            val itemText = parent.getItemAtPosition(position) as String

            //display toast message
            //Toast.makeText(this,itemText,Toast.LENGTH_SHORT).show()

            //open new activity
            val i = Intent(this,profileActivity::class.java)

            //sent data to new activity
            i.putExtra("selectedname",itemText)
            startActivity(i)


        }
    }
}
