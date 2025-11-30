package com.example.taskboard_backend.model.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ResourceNotFoundException(msg: String = "The resource you are requesting or modifying could not be found"):
    ErrorCodeException(msg = msg)