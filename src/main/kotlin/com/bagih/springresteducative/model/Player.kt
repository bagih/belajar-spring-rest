package com.bagih.springresteducative.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.Date

@Entity
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Int? = null,
    private val name: String,
    private val nationality: String,

    @JsonFormat(pattern = "dd-MM-yyyy")
    private val birthDate: Date,
    private val titles: Int
)
