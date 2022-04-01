package com.example.cm_lab8

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cm_lab8.adapters.todo_adpater
import com.example.cm_lab8.rv.todo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdpater: todo_adpater


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdpater = todo_adpater(ArrayList())

        rv1.adapter = todoAdpater
        rv1.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            val todoTitle = etTODO.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = todo(todoTitle, LocalDate.now())

                todoAdpater.addTodo(todo)

                etTODO.text.clear()
            }
        }
    }
}