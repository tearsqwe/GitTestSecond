package com.example.gittest2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpdateAcivity : AppCompatActivity() {
    val dbManager = DBManager(this)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)

        val etId: EditText = findViewById(R.id.etIdUpdate)
        val btnFind: Button = findViewById(R.id.button5)
        val btnUpdate: Button = findViewById(R.id.button6)
        val etName: EditText = findViewById(R.id.etNameUpdate)
        val etSurname: EditText = findViewById(R.id.etSurnameUpdate)
        val etAge: EditText = findViewById(R.id.etAgeUpdate)

        btnFind.setOnClickListener {
            dbManager.openDB()
            var listOfData = dbManager.readData(etId.text.toString())
            //listOfData = dbManager.readData(etId.text.toString())
            etName.setText(listOfData[0])
            etSurname.setText(listOfData[1])
            etAge.setText(listOfData[2])

            etName.visibility = View.VISIBLE
            etSurname.visibility = View.VISIBLE
            etAge.visibility = View.VISIBLE
            btnUpdate.visibility = View.VISIBLE

        }
        btnUpdate.setOnClickListener {
            val id = etId.text.toString()           // ID, как строка
            val name = etName.text.toString()       // Имя, как строка
            val surname = etSurname.text.toString() // Фамилия, как строка

            // Преобразуем возраст в Int
            val age = etAge.text.toString().toIntOrNull()

            if (age != null) {
                dbManager.update(id, name, surname, age)
            } else {
                // Обрабатываем ошибку, если возраст не является числом
                etAge.error = "Введите корректное число для возраста"
            }



            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}