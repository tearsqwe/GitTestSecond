package com.example.gittest2

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create)
        val dbManager=DBManager(this)
        //val dbHelper=DBHelper(this)

        val editText1: EditText = findViewById(R.id.editTextField1)
        val editText2: EditText = findViewById(R.id.editTextField2)
        val editText3: EditText = findViewById(R.id.editTextField3)
        val btnAdd: Button = findViewById(R.id.buttonAdd)

        btnAdd.setOnClickListener {

            dbManager.openDB()

            val column1=editText1.text.toString()
            val column2=editText2.text.toString()
            val column3=editText3.text.toString()

            dbManager.insert(column1,column2,column3)
            if(column1 ==" "|| column2==" "||column3==" ")
                Toast.makeText(this, "Что-то не заполнено", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Запись сохранена", Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}