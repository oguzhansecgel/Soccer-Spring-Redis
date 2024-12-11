package com.soccer_stats.soccer.controller;

import com.soccer_stats.soccer.dto.request.league.CreateLeagueRequest;
import com.soccer_stats.soccer.dto.request.league.UpdateLeagueRequest;
import com.soccer_stats.soccer.dto.response.league.CreateLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetAllLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetByIdLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.UpdateLeagueResponse;
import com.soccer_stats.soccer.service.LeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/league")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    @GetMapping("/getById/league/{id}")
    public Optional<GetByIdLeagueResponse> getByIdLeague(@PathVariable int id)
    {
        return leagueService.getByIdLeague(id);
    }
    @GetMapping("/getAll/leagues")
    public List<GetAllLeagueResponse> getAllLeague()
    {
        return leagueService.getAllLeague();
    }
    @PostMapping("/create/league")
    public CreateLeagueResponse createLeague(@RequestBody CreateLeagueRequest request)
    {
        return leagueService.createLeague(request);
    }
    @PutMapping("/update/league/{id}")
    public UpdateLeagueResponse updateLeague(@RequestBody UpdateLeagueRequest request,@PathVariable int id)
    {
        return leagueService.updateLeague(request,id);
    }
}
