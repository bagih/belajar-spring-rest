package com.bagih.springresteducative.controllers

import com.bagih.springresteducative.error.PlayerNotFoundException
import com.bagih.springresteducative.model.PlayerErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZonedDateTime

@ControllerAdvice
class PlayerExceptionHandler {
    @ExceptionHandler
    fun playerNotFoundHandler(exception: PlayerNotFoundException, request: HttpServletRequest): ResponseEntity<PlayerErrorResponse> {
        val playerErrorResponse = exception.message?.let {
            PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                request.requestURI,
                it
            )
        }
        return ResponseEntity(playerErrorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun genericHandler(exception: PlayerNotFoundException, request: HttpServletRequest): ResponseEntity<PlayerErrorResponse>{
        val playerErrorResponse = exception.message?.let {
            PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                request.requestURI,
                it
            )
        }
        return ResponseEntity(playerErrorResponse, HttpStatus.BAD_REQUEST)
    }
}