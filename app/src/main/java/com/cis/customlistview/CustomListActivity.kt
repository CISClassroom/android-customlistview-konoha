package com.cis.customlistview

import android.content.Intent
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

        var students = mutableListOf<Student>()
        //students.add(Student("นายกัมพล โชติทอง", "603410034-5", R.drawable.adun)) //มีแล้วบัค -..-
        students.add(Student("นายณัฐนนท์ ทาไธสง", "603410041-8", R.drawable.james))
        students.add(Student("นางสาวศศิกร กอเสนาะรส", "603410063-8", R.drawable.dream))
        students.add(Student("นางสาวธัญสิริ ผลไสว", "603410291-5", R.drawable.maprang))

        var listview: ListView = findViewById(R.id.customlistview)
        listview.adapter = StudentAdapter(
            this,
            R.layout.listitem_student, students
        )
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT)
                .show()

            //Intent
            if (position == 0) {
                var i = Intent(this, AdunActivity::class.java) //อดุลย์
                startActivity(i)
            } else if (position == 1) {
                var i = Intent(this, JamesActivity::class.java) //เจมส์
                startActivity(i)
            } else if (position == 2) {
                var i = Intent(this, DreamActivity::class.java) //ดรีม
                startActivity(i)
            } else if (position == 3) {
                var i = Intent(this, MaprangActivity::class.java) //มะปราง
                startActivity(i)
            }
        }
    }
}
