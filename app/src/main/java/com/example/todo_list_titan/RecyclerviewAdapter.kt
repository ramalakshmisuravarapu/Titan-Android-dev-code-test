package com.example.todo_list_titan

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(private val listData: ArrayList<Tasks>) :
    RecyclerView.Adapter<RecyclerviewAdapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(listData[position], position)
    }

    fun deleteItem(index: Int) {
        listData.removeAt(index)
        notifyDataSetChanged()
    }

    inner class myViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("ResourceAsColor")
        fun bind(property: Tasks, index: Int) {
            val taskText: TextView = view.findViewById(R.id.task_text)
            val deleteButton: Button = view.findViewById(R.id.delete_button)
            val checkbox: CheckBox = view.findViewById(R.id.check)
            val card: ConstraintLayout = view.findViewById(R.id.card)
            checkbox.isChecked = property.isCompleted
            taskText.text = property.name
            deleteButton.setOnClickListener {
                deleteItem(index)
            }
            checkbox.setOnCheckedChangeListener { compoundButton, isChecked ->
                property.isCompleted = isChecked
                if (checkbox.isChecked == true) {
                    card.setBackgroundColor(R.color.card_selected)
                }
            }


        }
    }
}