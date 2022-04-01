package com.example.cm_lab8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cm_lab8.R
import com.example.cm_lab8.rv.todo
import kotlinx.android.synthetic.main.todo_line_rv.view.*

class  todo_adpater (
    private val todos: ArrayList<todo>
    ) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.todo_line_rv,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todos[position]
        holder.apply {
            title.text = currentTodo.title
            date.text = currentTodo.date.toString()
            number.text = "#" + (position + 1).toString()
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(todo: todo){
        todos.add(todo)
        notifyDataSetChanged()
    }
}



class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val title = itemView.title
    val date = itemView.date
    val number = itemView.number
}