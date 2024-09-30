package com.example.gittest2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DBObject.TABLE_NAME, null, DBObject.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query=DBObject.SQL_CREATE_ENTRIES
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query= DBObject.SQL_DELETE_ENTRIES
        db!!.execSQL(query)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Entity.db"
    }
}