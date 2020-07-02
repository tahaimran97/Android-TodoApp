package com.example.sqlapp

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var data:Cursor
    lateinit var lists:ArrayList<Subject>
    lateinit var DB : SQLhelper
    lateinit var noItems:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // complete hex color #067340

        val goto_subject = findViewById<Button>(R.id.goto_subject)

        goto_subject.setOnClickListener {
            val intent = Intent(this@MainActivity,add_subject::class.java)
            startActivity(intent)
        }

        lists = ArrayList<Subject>()
        DB = SQLhelper(applicationContext)
        data = DB.data_getter
        noItems = findViewById(R.id.noitems_text)

        val adapter = Adapter(lists,applicationContext)
        val recycler = findViewById<RecyclerView>(R.id.recycler_view)

        showData()

        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(applicationContext,1)

        recycler.setOnClickListener {
            Toast.makeText(this@MainActivity,"Testing",Toast.LENGTH_SHORT).show()
        }


    }

    fun showData(){

        if(data.count == 0){
            noItems.visibility = View.VISIBLE
        }
        else {
            noItems.visibility = View.INVISIBLE
            while (data.moveToNext()) {

                lists.add(Subject(data.getString(1), data.getString(2)))

            }
        }

    }

    override fun onStart() {
        super.onStart()
        showData()
    }

}


//The following is the code for item_subject.xml, this is yet to be implemented
// the buttons functionality can be implemented in the Adapter

/*<LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp"
                android:orientation="horizontal"
                android:weightSum="3">

                <Button
                    android:id="@+id/done_btn"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="@drawable/complete_style"
                    android:text="Done"
                    android:textColor="#E6DEDE" />

                <Button
                    android:id="@+id/edit_btn"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginLeft="15dp"
                    android:layout_weight="1"
                    android:background="@drawable/edit_style"
                    android:text="Edit"
                    android:textColor="#E6DEDE" />

                <Button
                    android:id="@+id/delete_btn"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginLeft="15dp"
                    android:background="@drawable/delete_style"
                    android:text="Delete"
                    android:textColor="#E4E1E1" />
            </LinearLayout>*/