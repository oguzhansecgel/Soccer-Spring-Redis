package com.soccer_stats.soccer.service;

import com.soccer_stats.soccer.dto.request.playerStats.CreatePlayerStatsRequest;
import com.soccer_stats.soccer.dto.response.playerStats.CreatePlayerStatsResponse;
import com.soccer_stats.soccer.dto.response.playerStats.PlayerStatsResponseWithPlayer;

import java.util.List;

public interface PlayerStatsService {

    CreatePlayerStatsResponse createPlayerStats(CreatePlayerStatsRequest request);
    void updateGoalsStats(int playerId,int goals);
    void updateAssistStats(int playerId,int assists);
    void yellowCartStats(int playerId,int yellowCart);
    void redCartStats(int playerId,int redCart);
    List<PlayerStatsResponseWithPlayer> playerStatsWithPlayer(int playerId);
}
