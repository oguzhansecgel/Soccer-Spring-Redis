package com.soccer_stats.soccer.controller;

import com.soccer_stats.soccer.dto.request.playerStats.CreatePlayerStatsRequest;
import com.soccer_stats.soccer.dto.response.playerStats.CreatePlayerStatsResponse;
import com.soccer_stats.soccer.service.PlayerStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playerStats")
public class PlayerStatsController {

    private final PlayerStatsService playerStatsService;

    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @PostMapping("/create/playerStats")
    public CreatePlayerStatsResponse createPlayerStats(@RequestBody CreatePlayerStatsRequest request)
    {
        return playerStatsService.createPlayerStats(request);
    }

    @PutMapping("/{playerId}/goals")
    public ResponseEntity<String> updateGoals(@PathVariable int playerId, @RequestParam int goals)
    {
        playerStatsService.updateGoalsStats(playerId, goals);
        return ResponseEntity.ok("Player's goals updated successfully.");
    }
    @PutMapping("/{playerId}/asisst")
    public ResponseEntity<String> updateAssist(@PathVariable int playerId, @RequestParam int assist)
    {
        playerStatsService.updateAssistStats(playerId, assist);
        return ResponseEntity.ok("Player's assist updated successfully.");
    }
    @PutMapping("/{playerId}/yellowCart")
    public ResponseEntity<String> updateYellowCart(@PathVariable int playerId, @RequestParam int yellowCart)
    {
        playerStatsService.yellowCartStats(playerId, yellowCart);
        return ResponseEntity.ok("Player's yellowCart updated successfully.");
    }
    @PutMapping("/{playerId}/redCart")
    public ResponseEntity<String> updateRedCart(@PathVariable int playerId, @RequestParam int redCart)
    {
        playerStatsService.redCartStats(playerId, redCart);
        return ResponseEntity.ok("Player's redCart updated successfully.");
    }

}
