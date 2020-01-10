package com.cis.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_maprang.*

class MaprangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maprang)

        buttonM.setOnClickListener {
            this.finish()
        }
    }
}
