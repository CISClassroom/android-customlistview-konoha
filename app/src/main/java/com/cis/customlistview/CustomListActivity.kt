package com.cis.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.cis.customlistview.Adapter.StudentAdapter
import com.cis.customlistview.Model.Student

class CustomListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var student:Student =
            Student("Mickey","001",R.mipmap.ic_launcher)

        var students = mutableListOf<Student>()
        students.add(student)
        students.add(Student("Minnie","002",R.mipmap.ic_launcher))

        var listview:ListView = findViewById(R.id.customlistview)
        listview.adapter = StudentAdapter(this,
            R.layout.listitem_student,students)

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, position.toString(),
                Toast.LENGTH_SHORT).show()
        }
    }
}
