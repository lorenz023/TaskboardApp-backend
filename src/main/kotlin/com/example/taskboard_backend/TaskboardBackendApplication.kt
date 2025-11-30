package com.example.taskboard_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskboardBackendApplication

fun main(args: Array<String>) {
	runApplication<TaskboardBackendApplication>(*args)
}
