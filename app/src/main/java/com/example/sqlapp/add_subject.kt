package com.example.sqlapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class add_subject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)

        val DB = SQLhelper(applicationContext)
        val subject_edit_text = findViewById<EditText>(R.id.subject_edit_text)
        val task_edit_text = findViewById<EditText>(R.id.task_edit_text)
        val addsubjectbtn = findViewById<Button>(R.id.addbtn)

        addsubjectbtn.setOnClickListener {

            val subject_text = subject_edit_text.text.toString().trim()
            val task_text = task_edit_text.text.toString().trim()

            DB.add_data(subject_text,task_text)
            Toast.makeText(this@add_subject,"Task has been added",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@add_subject,MainActivity::class.java))
        }


    }
}