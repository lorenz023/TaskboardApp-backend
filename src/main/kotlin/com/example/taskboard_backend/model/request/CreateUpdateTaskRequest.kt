package com.example.taskboard_backend.model.request

import com.example.taskboard_backend.model.enum.TaskStatus

data class CreateUpdateTaskRequest(
    val title: String,
    val description: String,
    val status: TaskStatus,
    val assignedUsers: MutableList<String>,
)