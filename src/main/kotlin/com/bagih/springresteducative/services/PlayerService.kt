package com.bagih.springresteducative.services

import com.bagih.springresteducative.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(
    @Autowired
    val playerRepository: PlayerRepository
) {

}