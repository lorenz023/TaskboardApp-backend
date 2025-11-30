package com.example.taskboard_backend.repository

import com.example.taskboard_backend.model.db.Task
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository: MongoRepository<Task, String>