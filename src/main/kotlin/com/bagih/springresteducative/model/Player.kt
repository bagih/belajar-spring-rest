package com.bagih.springresteducative.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "player")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Int? = null,
    private val name: String,
    private val nationality: String,

    @JsonFormat(pattern = "dd-MM-yyyy")
    private val birthDate: Date,
    private val titles: Int
){
    fun setId(id: Int){
        this.id = id
    }
}
