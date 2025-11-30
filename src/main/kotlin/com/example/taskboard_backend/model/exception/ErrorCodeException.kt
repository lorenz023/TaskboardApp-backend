package com.example.taskboard_backend.model.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
open class ErrorCodeException(
    val code: Int = -1,
    msg: String = "Exception with error code $code",
    private val param: String = "",
) : Exception(msg) {
    fun response() = ErrorCodeExceptionResponse(javaClass.name, message, code, param)

    data class ErrorCodeExceptionResponse(val name: String, val message: String?, val code: Int, val param: String)
}