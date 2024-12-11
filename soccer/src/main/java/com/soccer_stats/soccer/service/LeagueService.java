package com.soccer_stats.soccer.service;

import com.soccer_stats.soccer.dto.request.league.CreateLeagueRequest;
import com.soccer_stats.soccer.dto.request.league.UpdateLeagueRequest;
import com.soccer_stats.soccer.dto.response.league.CreateLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetAllLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetByIdLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.UpdateLeagueResponse;

import java.util.List;
import java.util.Optional;

public interface LeagueService {
    Optional<GetByIdLeagueResponse> getByIdLeague(int leagueId);
    List<GetAllLeagueResponse> getAllLeague();
    CreateLeagueResponse createLeague(CreateLeagueRequest request);
    UpdateLeagueResponse updateLeague(UpdateLeagueRequest request, int id);
}
