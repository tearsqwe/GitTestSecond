package com.example.gittest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val dbManager=DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCreate: Button = findViewById(R.id.button)
        val btnRead: Button = findViewById(R.id.button2)
        val btnUpdate: Button = findViewById(R.id.button3)
        val btnDelete: Button = findViewById(R.id.button4)
        val tvDB: TextView=findViewById(R.id.textView2)

        btnCreate.setOnClickListener {
            val intent= Intent(this,CreateActivity::class.java )
            startActivity(intent)
        }
        btnRead.setOnClickListener {
            tvDB.text= ""
            dbManager.openDB()
            val dataList= dbManager.readData()
            for (i in dataList)
                tvDB.append(i+ "\n")


            //dbManager.readData()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}