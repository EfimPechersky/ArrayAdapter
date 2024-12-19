package com.example.arrayadapter

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var people:MutableList<String>;
    lateinit var adapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val lvPeople = findViewById<ListView>(R.id.people)
        val first_names = resources.getStringArray(R.array.first_names)
        val second_names = resources.getStringArray(R.array.second_names)// функция возвращает массив
        people=mutableListOf<String>() // массив неизменяем
        for (i in 1..20){
            people.add(first_names.random()+" "+second_names.random())
        }
        // TODO: создайте два string-array в ресурсах и получите список их случайных комбинаций
        adapter = ArrayAdapter<String>(this, R.layout.item, people)
        lvPeople.adapter = adapter // задаём адаптер (посредник) для отображения данных на списке

        // пример чтения строк из ресурсов

    }
    fun onAddPersonClick(view: View) {
        val ET = findViewById<EditText>(R.id.newfield)
        if (ET.text.toString()!="") {
            people.add(ET.text.toString())
            adapter.notifyDataSetChanged()
            ET.setText("")
        }
    }
}