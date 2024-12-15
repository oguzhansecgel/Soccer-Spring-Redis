package com.soccer_stats.soccer.mapper;

import com.soccer_stats.soccer.dto.request.playerStats.CreatePlayerStatsRequest;
import com.soccer_stats.soccer.dto.response.playerStats.PlayerStatsResponseWithPlayer;
import com.soccer_stats.soccer.model.PlayerStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerStatsMapping {


    PlayerStatsMapping INSTANCE = Mappers.getMapper(PlayerStatsMapping.class);

    @Mapping(target = "player.id",source = "playerId")
    PlayerStats createPlayerStats(CreatePlayerStatsRequest request);


    @Mapping(source = "player.id",target = "playerId")
    PlayerStatsResponseWithPlayer playerStatsWithPlayer(PlayerStats playerStats);
    List<PlayerStatsResponseWithPlayer> playerStatsWithPlayerToList(List<PlayerStats> playerStatsList);
}
