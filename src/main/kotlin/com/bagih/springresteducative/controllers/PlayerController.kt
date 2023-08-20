package com.bagih.springresteducative.controllers

import com.bagih.springresteducative.model.Player
import com.bagih.springresteducative.services.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
class PlayerController(
    @Autowired
    val playerService: PlayerService
) {

    @GetMapping("/welcome")
    fun welcome(): String{
        return "Welcome brooo"
    }

    @GetMapping("/players")
    fun allPlayers(): List<Player>{
        return playerService.getAllPlayers()
    }

    @GetMapping("/player/{id}")
    fun playerById(@PathVariable id: Int): Player?{
        return playerService.getPlayerById(id)
    }
}