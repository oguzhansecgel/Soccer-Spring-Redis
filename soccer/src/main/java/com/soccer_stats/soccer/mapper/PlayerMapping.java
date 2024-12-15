package com.soccer_stats.soccer.mapper;

import com.soccer_stats.soccer.dto.request.player.CreatePlayerRequest;
import com.soccer_stats.soccer.dto.request.player.UpdatePlayerRequest;
import com.soccer_stats.soccer.dto.response.player.GetAllPlayerResponse;
import com.soccer_stats.soccer.dto.response.player.GetAllPlayerWithTeam;
import com.soccer_stats.soccer.dto.response.player.GetByIdPlayerResponse;
import com.soccer_stats.soccer.model.Player;
import com.soccer_stats.soccer.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PlayerMapping {

    PlayerMapping INSTANCE = Mappers.getMapper(PlayerMapping.class);


    @Mapping(source = "currentTeamId", target = "currentTeam.id")
    Player createPlayer(CreatePlayerRequest request);
    Player updatePlayer(UpdatePlayerRequest request, @MappingTarget Player player);

    @Mapping(source = "currentTeam.name",target = "currentTeamName")
    GetByIdPlayerResponse getById(Player player);

    @Mapping(source = "currentTeam.name",target = "currentTeamName")
    GetAllPlayerResponse getAllPlayer(Player player);
    List<GetAllPlayerResponse> getAllPlayerToList(List<Player> player);

    @Mapping(source = "currentTeam.id", target = "teamId")
    GetAllPlayerWithTeam getAllPlayerWithTeam(Player player);

    List<GetAllPlayerWithTeam> getAllPlayerWithTeamToList(List<Player> player);


    default List<Team> mapTeamIdsToTeams(List<Integer> teamIds) {


        if (teamIds == null) {
            return new ArrayList<>();
        }

        return teamIds.stream()
                .map(id -> {
                    Team team = new Team();
                    team.setId(id);
                    return team;
                })
                .collect(Collectors.toList());
    }
}
