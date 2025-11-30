package com.example.taskboard_backend.model.exception

class UserNotFoundException(msg: String = "User not found"): ErrorCodeException(-2, msg)