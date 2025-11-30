package com.example.taskboard_backend.model.db

import com.example.taskboard_backend.model.enum.TaskStatus
import com.example.taskboard_backend.model.request.CreateUpdateTaskRequest
import org.springframework.data.annotation.Id

data class Task(
    @Id val id: String? = null,
    var title: String,
    var description: String,
    var status: TaskStatus = TaskStatus.TODO,
    var assignedUsers: MutableList<String> = mutableListOf(),
) {
    constructor(createTaskRequest: CreateUpdateTaskRequest) : this(
        title = createTaskRequest.title,
        description = createTaskRequest.description,
        status = createTaskRequest.status,
        assignedUsers = createTaskRequest.assignedUsers,
    )
}