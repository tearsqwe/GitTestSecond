package com.example.gittest2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val dbManager = DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCreate: Button = findViewById(R.id.button)
        val btnRead: Button = findViewById(R.id.button2)
        val btnUpdate: Button = findViewById(R.id.button3)
        val btnDelete: Button = findViewById(R.id.button4)
        val listView: ListView = findViewById(R.id.listViewForData)
        val etDelete: EditText= findViewById(R.id.editTextText2)

        btnCreate.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
        btnRead.setOnClickListener {
            //listView.text= ""
            dbManager.openDB()
            etDelete.visibility= View.VISIBLE
            val dataList = dbManager.readData()// в список добавляем записи из бд
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
            listView.adapter = adapter
        }

        btnDelete.setOnClickListener {
            val deletedRows= dbManager.delete(etDelete.text.toString())
            val dataList = dbManager.readData()
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
            listView.adapter = adapter

        }
        btnUpdate.setOnClickListener {
            val intent=Intent(this, UpdateAcivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}