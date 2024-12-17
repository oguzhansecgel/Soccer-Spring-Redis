package com.soccer_stats.search_service_kt.controller

import com.soccer_stats.search_service_kt.document.Player
import com.soccer_stats.search_service_kt.service.PlayerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/player")
class PlayerController(
    private val playerService: PlayerService
){


    @GetMapping("/all")
    fun getAllPlayer(): Iterable<Player>
    {
        return playerService.getAllPlayers()
    }
    @DeleteMapping
    fun deletallPlayer()
    {
        playerService.deleteAllPlayers()
    }
}