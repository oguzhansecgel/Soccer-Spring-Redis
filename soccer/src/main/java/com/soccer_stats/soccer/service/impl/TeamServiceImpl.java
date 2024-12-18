package com.soccer_stats.soccer.service.impl;

import com.soccer_stats.soccer.dto.request.team.CreateTeamRequest;
import com.soccer_stats.soccer.dto.request.team.UpdateTeamRequest;
import com.soccer_stats.soccer.dto.response.team.*;
import com.soccer_stats.soccer.mapper.TeamMapping;
import com.soccer_stats.soccer.model.Team;
import com.soccer_stats.soccer.repository.TeamRepository;
import com.soccer_stats.soccer.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<GetByIdTeamResponse> getByIdTeam(int id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.map(TeamMapping.INSTANCE::getByIdResponse);
    }

    @Override
    public List<GetAllTeamResponse> getAllTeamResponse() {
        List<Team> teams = teamRepository.findAll();
        return TeamMapping.INSTANCE.getAllTeamToList(teams);
    }

    @Override
    public CreateTeamResponse createTeam(CreateTeamRequest createTeamRequest) {
        Team team = TeamMapping.INSTANCE.createTeam(createTeamRequest);
        Team savedTeam = teamRepository.save(team);
        return new CreateTeamResponse(savedTeam.getId(),savedTeam.getName(),savedTeam.getSince(),savedTeam.getSeasonStart(),savedTeam.getSeasonEnd(),savedTeam.getLeague().getId());
    }

    @Override
    public UpdateTeamResponse updateTeam(UpdateTeamRequest updateTeamRequest, int id) {
        Team team = teamRepository.findById(id).get();
        Team team1 = TeamMapping.INSTANCE.updateTeam(updateTeamRequest, team);
        Team savedTeam = teamRepository.save(team1);
        return new UpdateTeamResponse(savedTeam.getId(),savedTeam.getName(),savedTeam.getSeasonStart(),savedTeam.getSeasonEnd(),savedTeam.getSince(),savedTeam.getLeague().getId());
    }

    @Override
    public List<GetAllTeamWithLeague> getTeamsByLeagueId(int leagueId) {
       List<Team> team = teamRepository.findByLeague_Id(leagueId);
        return TeamMapping.INSTANCE.getAllTeamWithLeagueToList(team);
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
