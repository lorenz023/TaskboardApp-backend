package com.example.taskboard_backend.controller

import com.example.taskboard_backend.model.db.Task
import com.example.taskboard_backend.model.request.CreateUpdateTaskRequest
import com.example.taskboard_backend.service.TaskService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController()
class TaskController(
    private val taskService: TaskService
) {

    @GetMapping("/tasks")
    fun getTasks(
        principal: Principal
    ): List<Task> {
        return taskService.getTasks()
    }

    @GetMapping("/tasks/details/{taskId}")
    fun getTaskDetails(
        @PathVariable taskId: String,
        principal: Principal
    ): Task {
        return taskService.getTaskDetails(taskId)
    }

    @PostMapping("/tasks/create")
    fun createTask(
        @RequestBody createTaskRequest: CreateUpdateTaskRequest,
        principal: Principal
    ) {
        taskService.createTask(createTaskRequest)
    }

    @PatchMapping("/tasks/update/{taskId}")
    fun updateTask(
        @PathVariable taskId: String,
        @RequestBody updateTaskRequest: CreateUpdateTaskRequest,
        principal: Principal
    ) {
        taskService.updateTask(taskId, updateTaskRequest)
    }

    @DeleteMapping("/tasks/delete/{taskId}")
    fun deleteTask(
        @PathVariable taskId: String,
        principal: Principal
    ) {
        taskService.deleteTask(taskId)
    }
}