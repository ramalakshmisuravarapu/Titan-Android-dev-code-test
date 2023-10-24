package com.example.todo_list_titan

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list_titan.ui.theme.TODO_List_TITANTheme

class MainActivity : ComponentActivity() {
    private lateinit var recycle: RecyclerView
    private lateinit var adapter: RecyclerviewAdapter
    private lateinit var add_button: Button
    private lateinit var enter_text: EditText
    private var tasks = ArrayList<Tasks>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        add_button = findViewById(R.id.Add_button)
        enter_text = findViewById(R.id.edit_text_task)
        recycle = findViewById(R.id.recycle)
        val layoutManager = LinearLayoutManager(this)
        recycle.layoutManager = layoutManager
        tasks.add(Tasks(1,"TITAN"))
        tasks.add(Tasks(2,"Fastrack"))
        tasks.add(Tasks(3,"Sonata"))
        tasks.add(Tasks(4,"Raga"))
        tasks.add(Tasks(5,"Nebula"))
        tasks.add(Tasks(6,"Octane"))
        tasks.add(Tasks(7,"Xylys"))


        add_button.setOnClickListener {
            val task_Name = enter_text.text.toString().trim()
            if (task_Name.isNotEmpty()) {
                val taskId = tasks.size + 1
                val newTask = Tasks(taskId, task_Name)
                tasks.add(newTask)
                enter_text.text.clear()
            }
        }
        adapter = RecyclerviewAdapter(tasks)
        recycle.adapter = adapter
        recycle.adapter?.notifyDataSetChanged()
    }
}
