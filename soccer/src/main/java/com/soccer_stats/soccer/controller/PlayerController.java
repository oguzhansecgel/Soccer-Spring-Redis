package com.soccer_stats.soccer.controller;

import com.soccer_stats.soccer.dto.request.player.CreatePlayerRequest;
import com.soccer_stats.soccer.dto.response.player.CreatePlayerResponse;
import com.soccer_stats.soccer.dto.response.player.GetAllPlayerResponse;
import com.soccer_stats.soccer.dto.response.player.GetAllPlayerWithTeam;
import com.soccer_stats.soccer.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getAll/player")
    public List<GetAllPlayerResponse> getAllPlayer()
    {
        return playerService.getAllPlayers();
    }
    @GetMapping("/getAll/player/{teamId}")
    public List<GetAllPlayerWithTeam> getAllPlayerWithTeams(@PathVariable int teamId)
    {
        return playerService.getAllPlayersWithTeam(teamId);
    }

    @PostMapping("/create/player")
    public CreatePlayerResponse createPlayer(@RequestBody CreatePlayerRequest request)
    {
        return playerService.createPlayer(request);
    }
    @PutMapping("/transfer/{playerId}/{fromTeamId}/{toTeamId}")
    public void transferPlayer(@PathVariable int playerId, @PathVariable int fromTeamId, @PathVariable int toTeamId)
    {
        playerService.transferPlayer(playerId, fromTeamId, toTeamId);
    }
}
