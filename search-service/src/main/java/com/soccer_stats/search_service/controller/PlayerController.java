package com.soccer_stats.search_service.controller;

import com.soccer_stats.search_service.document.Player;
import com.soccer_stats.search_service.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping("/listAll/player")
    public Iterable<Player> getAllPlayers()
    {
        return playerService.getPlayers();
    }
}
