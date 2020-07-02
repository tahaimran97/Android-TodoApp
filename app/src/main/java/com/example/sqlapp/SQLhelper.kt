package com.example.sqlapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLhelper (context: Context) : SQLiteOpenHelper(context,DB_name,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT , S_title TEXT , S_description TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS" + TB_name)

    }

    fun add_data (subject:String,task:String){

        val DB = this.writableDatabase
        val values = ContentValues()
        values.put(title,subject)
        values.put(description,task)

        DB.insert(TB_name,null,values)

    }

    fun delete_data(id:String):Int{

        var DB = this.writableDatabase
        var item:Int = DB.delete(TB_name,"id = ?", arrayOf(id))

        return item
    }

    val data_getter:Cursor get() {

        val DB = this.writableDatabase
        var data = DB.rawQuery("select * from " + TB_name,null)
        return data
    }

    companion object{

        val DB_name = "subjects.db "
        val TB_name = "Subject "
        val id = "ID "
        val title = "S_title "
        val description = "S_description "

    }

}