package com.soccer_stats.soccer.controller;

import com.soccer_stats.soccer.dto.request.team.CreateTeamRequest;
import com.soccer_stats.soccer.dto.request.team.UpdateTeamRequest;
import com.soccer_stats.soccer.dto.response.team.*;
import com.soccer_stats.soccer.model.Team;
import com.soccer_stats.soccer.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping("/getById/team/{id}")
    public Optional<GetByIdTeamResponse> getByIdTeam(@PathVariable int id)
    {
        return teamService.getByIdTeam(id);
    }
    @GetMapping("/list/team")
    public List<GetAllTeamResponse> getAllTeam()
    {
        return teamService.getAllTeamResponse();
    }
    @GetMapping("/by-league/{leagueId}")
    public List<GetAllTeamWithLeague> getTeamsByLeagueId(@PathVariable int leagueId) {
        return teamService.getTeamsByLeagueId(leagueId);
    }
    @PostMapping("/create/team")
    public CreateTeamResponse createTeam(@RequestBody CreateTeamRequest createTeamRequest)
    {
        return teamService.createTeam(createTeamRequest);
    }
    @PutMapping("/update/team/{id}")
    public UpdateTeamResponse updateTeam(@PathVariable int id, @RequestBody UpdateTeamRequest updateTeamRequest)
    {
        return teamService.updateTeam(updateTeamRequest,id);
    }
}
