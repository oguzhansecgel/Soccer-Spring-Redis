package com.soccer_stats.soccer.service;

import com.soccer_stats.soccer.dto.request.team.CreateTeamRequest;
import com.soccer_stats.soccer.dto.request.team.UpdateTeamRequest;
import com.soccer_stats.soccer.dto.response.team.CreateTeamResponse;
import com.soccer_stats.soccer.dto.response.team.GetAllTeamResponse;
import com.soccer_stats.soccer.dto.response.team.GetByIdTeamResponse;
import com.soccer_stats.soccer.dto.response.team.UpdateTeamResponse;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<GetByIdTeamResponse> getByIdTeam(int id);
    List<GetAllTeamResponse> getAllTeamResponse();
    CreateTeamResponse createTeam(CreateTeamRequest createTeamRequest);
    UpdateTeamResponse updateTeam(UpdateTeamRequest updateTeamRequest,int id);
}
