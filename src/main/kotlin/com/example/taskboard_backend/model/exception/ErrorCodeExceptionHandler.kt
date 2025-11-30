package com.example.taskboard_backend.model.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorCodeExceptionHandler: ResponseEntityExceptionHandler() {

    private val headers = HttpHeaders()
    init {
        headers.contentType = MediaType.APPLICATION_JSON
    }

    @ExceptionHandler(ErrorCodeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleErrorCodeException(ex: ErrorCodeException, request: WebRequest): ResponseEntity<ErrorCodeException.ErrorCodeExceptionResponse> {
        return ResponseEntity(ex.response(), headers, HttpStatus.BAD_REQUEST)
    }

}