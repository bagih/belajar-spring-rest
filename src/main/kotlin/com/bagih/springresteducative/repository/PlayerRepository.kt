package com.bagih.springresteducative.repository

import com.bagih.springresteducative.model.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, Int> {
}