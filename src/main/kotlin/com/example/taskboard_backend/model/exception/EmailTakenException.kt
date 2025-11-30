package com.example.taskboard_backend.model.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class EmailTakenException(msg: String = "Email already taken"): ErrorCodeException(-5, msg)