package com.bagih.springresteducative.repository

import com.bagih.springresteducative.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PlayerRepository: JpaRepository<Player, Int> {
}