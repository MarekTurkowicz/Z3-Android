package com.example.z3kotlin

import Task
import androidx.compose.animation.core.rememberTransition
import java.util.UUID

object TaskStorage {
    val taskStorage = TaskStorage
    val taskList = mutableListOf<Task>()
    init {
       for (i in 1..20){
           val task = Task(name = " Pilne cóś $i", done = (i % 3 == 0))
           taskList.add(task)
       }
    }
    fun getInstance(): TaskStorage = taskStorage

    fun getList(): MutableList<Task> = taskList

    fun getElementOfList(id: UUID): Task? = taskList.find { it.id == id }

    fun updateTask(task: Task){
        val index = taskList.indexOfFirst { it.id == task.id }
        if (index == -1){
            return
        }else{
            taskList[index] = task
        }


    }
}