package com.example.z3kotlin

import Task
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.UUID


class TaskListFragment: Fragment() {
    lateinit var recycleView: RecyclerView
    lateinit var adapter: TaskAdapter
    val KEY_EXTRA_TASK_ID = "extraKey"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)
        recycleView = view.findViewById<RecyclerView>(R.id.task_recycler_view)
        adapter = TaskAdapter(TaskStorage.getList())
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(context)
        updateView()
        return view

    }

    override fun onResume() {
        super.onResume()
        updateView()
    }

    fun updateView(){
        adapter.notifyDataSetChanged()
    }

    inner class TaskHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        init {
            view.setOnClickListener(this)
        }
        val nameTextView = view.findViewById<TextView>(R.id.task_item_name)
        val dateTextView = view.findViewById<TextView>(R.id.task_item_date)
        lateinit var task: Task

        fun bind(task: Task){
            this.task = task
            nameTextView.text = task.name
            dateTextView.text = task.date.toString()

            if (task.done){
                nameTextView.paintFlags = nameTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }else{
                nameTextView.paintFlags = nameTextView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()          }
        }
        override fun onClick(view: View?) {
            var intent = Intent(activity, MainActivity::class.java)
            intent.putExtra(KEY_EXTRA_TASK_ID, task.id)
            startActivity(intent)
        }
    }

    inner class TaskAdapter(private var tasks: MutableList<Task>): RecyclerView.Adapter<TaskHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_task, parent, false)
            val viewHolder = TaskHolder(view)
            return viewHolder
        }

        override fun getItemCount(): Int  = tasks.size

        override fun onBindViewHolder(holder: TaskHolder, position: Int) {
            holder.bind(tasks[position])
        }

    }


}