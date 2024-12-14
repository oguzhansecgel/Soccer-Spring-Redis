package com.soccer_stats.soccer.mapper;

import com.soccer_stats.soccer.dto.request.team.CreateTeamRequest;
import com.soccer_stats.soccer.dto.request.team.UpdateTeamRequest;
import com.soccer_stats.soccer.dto.response.team.GetAllTeamResponse;
import com.soccer_stats.soccer.dto.response.team.GetAllTeamWithLeague;
import com.soccer_stats.soccer.dto.response.team.GetByIdTeamResponse;
import com.soccer_stats.soccer.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeamMapping {

    TeamMapping INSTANCE = Mappers.getMapper(TeamMapping.class);

    @Mapping(source = "leagueId",target = "league.id")
    Team createTeam(CreateTeamRequest request);

    @Mapping(source = "leagueId",target = "league.id")
    Team updateTeam(UpdateTeamRequest request, @MappingTarget Team team);

    @Mapping(source = "league.leagueName",target = "leagueName")
    GetByIdTeamResponse getByIdResponse(Team team);

    @Mapping(source = "league.leagueName",target = "leagueName")
    GetAllTeamResponse getAllTeam(Team team);
    List<GetAllTeamResponse> getAllTeamToList(List<Team> teams);

    @Mapping(source = "league.leagueName",target = "leagueName")
    GetAllTeamWithLeague getAllTeamWithLeague(Team team);
    List<GetAllTeamWithLeague> getAllTeamWithLeagueToList(List<Team> teams);
}
