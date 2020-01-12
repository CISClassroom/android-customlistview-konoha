# รายงานผลการทดลอง

นายกัมพล โชติทอง 603410034-5
นายณัฐนนท์ ทาไธสง 603410041-8
นางสาวศศิกร กอเสนาะรส 603410063-8
นางสาวธัญสิริ ผลไสว 603410291-5

## Custom Listview

แสดงคำสั่งสำหรับแสดงข้อมูลชื่อนักศึกษาภายในกลุ่ม กลุ่มละไม่เกิน 4 คน รายละเอียดข้อมูลประกอบด้วย

- ชื่อ-นามสกุล
- รหัสนักศึกษา
- รูปภาพ

เมื่อทำการเลือกรายชื่อนักศึกษาจะทำการเปิดไปยังหน้าที่แสดงข้อมูลนักศึกษาเพิ่มเติม ข้อมูลนักศึกษาประกอบด้วย

- ชื่อ-นามสกุล
- รหัสนักศึกษา
- รูปภาพ
- สาขาวิชา
- อีเมล
- เบอร์โทรศัพท์
- Github

ให้นักศึกษาออกแบบ layout ได้ตามความเหมาสม

## Custom Listview Report

### ข้อมูล Array

```xml
        var student:Student = Student("นายกัมพล โชติทอง", "603410034-5", R.drawable.adun)

        var students = mutableListOf<Student>()
        students.add(student)
        students.add(Student("นายณัฐนนท์ ทาไธสง", "603410041-8", R.drawable.james))
        students.add(Student("นางสาวศศิกร กอเสนาะรส", "603410063-8", R.drawable.dream))
        students.add(Student("นางสาวธัญสิริ ผลไสว", "603410291-5", R.drawable.maprang))

```

### Custom Listview Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".CustomListActivity">

    <ListView
        android:id="@+id/customlistview"
        android:layout_width="409dp"
        android:layout_height="729dp"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="2dp" />
</LinearLayout>
```

### setOnItemClickListener และการส่งข้อมูลไปอีก Activity

```kotlin
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
```

### การรับข้อมูลจากอีก Activity

```kotlin
public class StudentAdapter (var mCtx:Context,
                             var resource:Int,
                             var items:List<Student>) //จาก Student.kt
    :ArrayAdapter<Student>(mCtx,resource,items){
    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup):View{
        val layout:LayoutInflater = LayoutInflater.from(mCtx)
        val v:View = layout.inflate(resource,null)
        val icon:ImageView = v.findViewById(R.id.imageView)
        val name:TextView = v.findViewById(R.id.textView)
        val id:TextView = v.findViewById(R.id.textView2)

        val student:Student = items[position]

        name.text = student.name
        id.text = student.id
        try {
            icon.setImageDrawable(mCtx.getDrawable(student.icon))
        } catch (ex: Exception) {

        }

        return v
    }
}

```
