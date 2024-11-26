package com.example.z3kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.todoapp.TaskFragment

class TaskListActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = TaskListFragment()


}