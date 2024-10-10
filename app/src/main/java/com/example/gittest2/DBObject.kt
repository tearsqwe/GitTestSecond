package com.example.gittest2

import android.provider.BaseColumns

object DBObject : BaseColumns {
    const val TABLE_NAME = "Person"
    const val COLUMN_NAME_NAME = "Name"
    const val COLUMN_NAME_SURNAME = "Surname"
    const val COLUMN_NAME_AGE = "Age"

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${DBObject.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${DBObject.COLUMN_NAME_NAME} TEXT," +
                "${DBObject.COLUMN_NAME_SURNAME} TEXT," +
                "${DBObject.COLUMN_NAME_AGE} INTEGER)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DBObject.TABLE_NAME}"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Person.db"
}