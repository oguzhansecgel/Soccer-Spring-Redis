package com.soccer_stats.soccer.mapper;

import com.soccer_stats.soccer.dto.request.playerStats.CreatePlayerStatsRequest;
import com.soccer_stats.soccer.model.PlayerStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerStatsMapping {


    PlayerStatsMapping INSTANCE = Mappers.getMapper(PlayerStatsMapping.class);

    @Mapping(target = "player.id",source = "playerId")
    PlayerStats createPlayerStats(CreatePlayerStatsRequest request);
}
