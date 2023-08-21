package com.bagih.springresteducative.services

import com.bagih.springresteducative.model.Player
import com.bagih.springresteducative.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PlayerService(
    @Autowired
    val playerRepository: PlayerRepository
) {

    fun getAllPlayers(): List<Player>{
        return playerRepository.findAll()
    }

    fun getPlayerById(id: Int): Player?{
        val tempPlayer: Optional<Player> = playerRepository.findById(id)
        var player: Player? = null
        if (tempPlayer.isPresent){
            player = tempPlayer.get()
        }
        return player
    }

    fun addPlayer(player: Player): Player{
        return playerRepository.save(player)
    }
}