package com.soccer_stats.soccer.service.impl;

import com.soccer_stats.soccer.dto.request.league.CreateLeagueRequest;
import com.soccer_stats.soccer.dto.request.league.UpdateLeagueRequest;
import com.soccer_stats.soccer.dto.response.league.CreateLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetAllLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetByIdLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.UpdateLeagueResponse;
import com.soccer_stats.soccer.mapper.LeagueMapping;
import com.soccer_stats.soccer.model.League;
import com.soccer_stats.soccer.repository.LeagueRepository;
import com.soccer_stats.soccer.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Optional<GetByIdLeagueResponse> getByIdLeague(int leagueId) {
        Optional<League> league = leagueRepository.findById(leagueId);
        if (league.isEmpty()) {}
        return league.map(LeagueMapping.INSTANCE::getByIdLeague);
    }

    @Override
    public List<GetAllLeagueResponse> getAllLeague() {
        List<League> leagues = leagueRepository.findAll();
        return LeagueMapping.INSTANCE.getAllLeaguetoList(leagues);
    }

    @Override
    public CreateLeagueResponse createLeague(CreateLeagueRequest request) {
        League league = LeagueMapping.INSTANCE.createLeagueMapping(request);
        League savedLeague = leagueRepository.save(league);
        return new CreateLeagueResponse(savedLeague.getId(),savedLeague.getLeagueName(),savedLeague.getStartDate(),savedLeague.getEndDate(),savedLeague.getCountry());
    }

    @Override
    public UpdateLeagueResponse updateLeague(UpdateLeagueRequest request, int id) {
        Optional<League> optionalLeague = leagueRepository.findById(id);
        if (optionalLeague.isEmpty()) {}
        League leagueExisting = optionalLeague.get();
        League league = LeagueMapping.INSTANCE.updateLeagueMapping(request,leagueExisting);
        League savedLeague = leagueRepository.save(league);
        return new UpdateLeagueResponse(savedLeague.getId(), savedLeague.getLeagueName(),savedLeague.getStartDate(),savedLeague.getEndDate(),savedLeague.getCountry());
    }
}
