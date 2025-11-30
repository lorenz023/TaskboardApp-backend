package com.example.taskboard_backend.service

import com.example.taskboard_backend.model.db.Task
import com.example.taskboard_backend.model.exception.ResourceNotFoundException
import com.example.taskboard_backend.model.request.CreateUpdateTaskRequest
import com.example.taskboard_backend.repository.TaskRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getTasks(): List<Task> {
        return taskRepository.findAll()
    }

    fun getTaskDetails(taskId: String): Task {
        return taskRepository.findById(taskId)
            .orElseThrow { ResourceNotFoundException("No task with id $taskId was found") }
    }

    fun createTask(createTaskRequest: CreateUpdateTaskRequest) {
        val task = taskRepository.save(Task(createTaskRequest))
        logger.info("Created task with id: ${task.id}")
    }

    fun updateTask(taskId: String, updateTaskRequest: CreateUpdateTaskRequest) {
        val task = taskRepository.findById(taskId).orElseThrow { ResourceNotFoundException() }

        task.title = updateTaskRequest.title
        task.description = updateTaskRequest.description
        task.status = updateTaskRequest.status
        task.assignedUsers = updateTaskRequest.assignedUsers

        taskRepository.save(task)
        logger.info("Task with id: ${task.id} updated")
    }

    fun deleteTask(taskId: String) {
        val task = taskRepository.findById(taskId).orElseThrow { ResourceNotFoundException() }

        taskRepository.delete(task)
        logger.info("Task with id: ${task.id} deleted")
    }

}