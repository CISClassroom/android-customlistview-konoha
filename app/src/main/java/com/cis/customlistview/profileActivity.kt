package com.cis.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class profileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //get data from activity
        //val data = intent.getStringExtra("selectedname")
        //Toast.makeText(this,data, Toast.LENGTH_SHORT).show()
    }
}
