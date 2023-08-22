package com.bagih.springresteducative.repository

import com.bagih.springresteducative.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

interface PlayerRepository: JpaRepository<Player, Int> {
    @Modifying
    @Query("update Player p set p.titles = :titles where p.id = :id")
    fun updateTitles(@Param("id") id: Int, @Param("titles") titles: Int)
}