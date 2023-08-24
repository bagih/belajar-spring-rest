package com.bagih.springresteducative.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class PlayerErrorResponse(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val timestamp: ZonedDateTime,
    val statusCode: Int,
    val path: String,
    val message: String
)