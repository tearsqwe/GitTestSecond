package com.example.gittest2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(val context: Context) {

    val DBHelper=DBHelper(context)
    var db:SQLiteDatabase?= null


    fun openDB()
    {
        db=DBHelper.writableDatabase
    }
    fun insert( column1: String, column2:String, column3:String)
    {

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
    fun readData(): ArrayList<String>{
        val dataList=ArrayList<String>()
        val cursor= db?.query(DBObject.TABLE_NAME,null,null,null,
            null,null,null)
        while(cursor?.moveToNext()!!) {
            //val dataText=cursor?.getString(cursor.getColumnIndexOrThrow(DBObject.COLUMN_NAME_NAME))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(DBObject.COLUMN_NAME_NAME))
            val surname =cursor.getString(cursor.getColumnIndexOrThrow(DBObject.COLUMN_NAME_SURNAME))
            val age =cursor.getString(cursor.getColumnIndexOrThrow(DBObject.COLUMN_NAME_AGE))

            val dataText="$name, $surname, $age"

            dataList.add(dataText)
            }
            cursor.close()
        return dataList
    }



}