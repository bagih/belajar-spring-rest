package com.bagih.springresteducative.controllers

import com.bagih.springresteducative.model.Player
import com.bagih.springresteducative.services.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
class PlayerController(
    @Autowired
    val playerService: PlayerService
) {

    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome brooo"
    }

    @GetMapping("/players")
    fun allPlayers(): List<Player> {
        return playerService.getAllPlayers()
    }

    @GetMapping("/player/{id}")
    fun playerById(@PathVariable id: Int): Player? {
        return playerService.getPlayerById(id)
    }

    @PostMapping("/player")
    fun addPlayer(@RequestBody player: Player): Player {
        player.setId(0)
        return playerService.addPlayer(player)
    }

    @PutMapping("/player/{id}")
    fun updatePlayer(@PathVariable id: Int, @RequestBody player: Player): Player {
        return playerService.updatePlayer(id, player)
    }

    @PatchMapping("/player/{id}")
    fun partialUpdate(@PathVariable id: Int, @RequestBody playerPatch: Map<String, JvmType.Object>): Player {
        return playerService.partialUpdatePlayer(id, playerPatch)
    }

    @PatchMapping("/player/{id}/titles")
    fun updateTitles(@PathVariable id: Int, @RequestBody titles: Int){
        playerService.updateTitles(id, titles)
    }

    @DeleteMapping("/player/{id}")
    fun deletePlayer(@PathVariable id: Int){
        playerService.deletePlayer(id)
    }
}