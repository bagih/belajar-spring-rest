package com.bagih.springresteducative.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController {

    @GetMapping("/welcome")
    fun welcome(): String{
        return "Welcome brooo"
    }
}