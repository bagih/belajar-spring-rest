package com.bagih.springresteducative.services

import com.bagih.springresteducative.model.Player
import com.bagih.springresteducative.repository.PlayerRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.ReflectionUtils
import java.lang.RuntimeException
import java.lang.reflect.Field
import java.util.Optional
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

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

    fun updatePlayer(id: Int, player: Player): Player{
        val tempPlayer: Optional<Player> = playerRepository.findById(id)

        if (tempPlayer.isEmpty){
            throw RuntimeException("Player with id $id is not found")
        }

        player.setId(id)
        return playerRepository.save(player)
    }

    fun partialUpdatePlayer(id: Int, partialPlayer: Map<String, JvmType.Object>): Player{
        val player: Optional<Player> = playerRepository.findById(id)

        if (player.isPresent){
            partialPlayer.forEach { (key, value) ->
                println("key: $key , value: $value")
                val field: Field? = ReflectionUtils.findField(Player::class.java, key)
                field?.let {
                    ReflectionUtils.makeAccessible(it)
                    ReflectionUtils.setField(it, player.get(), value)
                }
            }
        } else throw RuntimeException("player with id of $id is not found")

        return playerRepository.save(player.get())
    }

    @Transactional
    fun updateTitles(id: Int, titles: Int){
        val tempPlayer: Optional<Player> = playerRepository.findById(id)

        if (tempPlayer.isEmpty){
            throw RuntimeException("player with id of $id is not found")
        }
        playerRepository.updateTitles(id, titles)
    }

    fun deletePlayer(id: Int){
        val tempPlayer: Optional<Player> = playerRepository.findById(id)

        if(tempPlayer.isEmpty){
            throw RuntimeException("player with id of $id is not found")
        }
        playerRepository.delete(tempPlayer.get())
    }
}