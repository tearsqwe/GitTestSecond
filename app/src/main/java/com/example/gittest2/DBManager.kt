package com.example.gittest2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

class DBManager(val context: Context) {

    val DBHelper=DBHelper(context)


    fun openDB()
    {
        val db=DBHelper.writableDatabase
    }
    fun insert( column1: String, column2:String, column3:String)
    {
        val db= DBHelper.writableDatabase

        val values= ContentValues().apply {
            put (DBObject.COLUMN_NAME_NAME, column1)
            put(DBObject.COLUMN_NAME_SURNAME, column2)
            put(DBObject.COLUMN_NAME_AGE, column3)
        }
        val newRowId=db?.insert(DBObject.TABLE_NAME,null, values)
    }
    fun closeDB()
    {
        DBHelper.close()
    }


}