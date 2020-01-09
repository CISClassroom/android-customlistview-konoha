package com.cis.customlistview.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cis.customlistview.Model.Student
import com.cis.customlistview.R

public class StudentAdapter(var mCtx:Context,
                            var resource:Int,
                            var items:List<Student>)
    //extent from adapter

    :ArrayAdapter<Student> (mCtx,resource,items){
    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layout:LayoutInflater = LayoutInflater.from(mCtx)

        val v:View = layout.inflate(resource,null)
        val icon: ImageView = v.findViewById(R.id.imageView)
        val name: TextView = v.findViewById(R.id.textView)
        val id: TextView = v.findViewById(R.id.textView2)

        val student:Student = items[position]

        name.text = student.name
        id.text = student.id
        icon.setImageDrawable(mCtx.getDrawable(student.icon))
        return  v
    }
}