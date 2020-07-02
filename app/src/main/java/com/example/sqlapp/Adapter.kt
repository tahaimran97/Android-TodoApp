package com.example.sqlapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_subject.view.*

class Adapter (data:ArrayList<Subject>,var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var data : List<Subject>
    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.item_subject,parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subject.text = data[position].subject
        holder.task.text = data[position].task
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var subject:TextView
        var task:TextView

        init {
            subject = itemView.findViewById<TextView>(R.id.subject_textview)
            task = itemView.findViewById<TextView>(R.id.task_textview)
        }


    }


}