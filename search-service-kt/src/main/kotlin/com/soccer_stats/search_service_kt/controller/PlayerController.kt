package com.soccer_stats.search_service_kt.controller

import com.soccer_stats.search_service_kt.model.Player
import com.soccer_stats.search_service_kt.service.PlayerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/search"])
class PlayerController(
    private val playerService: PlayerService,
    service: PlayerService
) {

    @GetMapping("getAll/players")
    fun getAllPlayers(): Iterable<Player>
    {
        return playerService.getPlayers();
    }
    @PostMapping("/create/player")
    fun createPlayer(@RequestBody player: Player): Player
    {
        return playerService.createPlayer(player);
    }

}