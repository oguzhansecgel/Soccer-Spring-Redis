package com.soccer_stats.soccer.service;

import com.soccer_stats.soccer.dto.request.player.CreatePlayerRequest;
import com.soccer_stats.soccer.dto.request.player.UpdatePlayerRequest;
import com.soccer_stats.soccer.dto.response.player.*;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    Optional<GetByIdPlayerResponse> getByIdPlayer(int id);
    List<GetAllPlayerResponse> getAllPlayers();
    CreatePlayerResponse createPlayer(CreatePlayerRequest request);
    UpdatePlayerResponse updatePlayer(UpdatePlayerRequest request, int id);
    List<GetAllPlayerWithTeam> getAllPlayersWithTeam(int teamId);
    void transferPlayer(int playerId,int fromTeam, int toTeam);
}
