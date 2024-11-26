package com.example.todoapp

import Task
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.z3kotlin.R
import com.example.z3kotlin.TaskStorage
import java.util.UUID

class TaskFragment : Fragment() {
   private lateinit var task: Task
//    var task: Task? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var taskId = arguments?.getSerializable("extraKey", UUID::class.java)
        task = TaskStorage.getInstance().getElementOfList(taskId!!)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task, container, false)

        val nameField = view?.findViewById<EditText>(R.id.task_name)
        val dateButton = view?.findViewById<Button>(R.id.task_date)
        val doneCheckBox = view?.findViewById<CheckBox>(R.id.task_done)
        val saveButton = view?.findViewById<Button>(R.id.save)

        nameField?.setText(task.name)
        doneCheckBox?.isChecked =task.done

        saveButton?.setOnClickListener{
            task = Task(id = task.id, name = nameField?.text.toString(), date = task.date, done = doneCheckBox!!.isChecked)
            TaskStorage.updateTask(task)
        }

        return view
    }

    companion object{
        fun newInstance(taskId: UUID): TaskFragment{
            val bundle = Bundle()
            bundle.putSerializable("extraKey", taskId)
            var taskFragment = TaskFragment()
            taskFragment.arguments = bundle
            return taskFragment


        }
    }




}
