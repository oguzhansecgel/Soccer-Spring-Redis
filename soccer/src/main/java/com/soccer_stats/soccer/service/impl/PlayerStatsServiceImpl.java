package com.soccer_stats.soccer.service.impl;

import com.soccer_stats.soccer.dto.request.playerStats.CreatePlayerStatsRequest;
import com.soccer_stats.soccer.dto.response.playerStats.CreatePlayerStatsResponse;
import com.soccer_stats.soccer.mapper.PlayerStatsMapping;
import com.soccer_stats.soccer.model.PlayerStats;
import com.soccer_stats.soccer.repository.PlayerStatsRepository;
import com.soccer_stats.soccer.service.PlayerStatsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {


    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsServiceImpl(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    @Override
    public CreatePlayerStatsResponse createPlayerStats(CreatePlayerStatsRequest request) {
        PlayerStats playerStats = PlayerStatsMapping.INSTANCE.createPlayerStats(request);
        PlayerStats savedPlayerStats = playerStatsRepository.save(playerStats);
        return new CreatePlayerStatsResponse(savedPlayerStats.getId(),
                savedPlayerStats.getPlayer().getId(),
                savedPlayerStats.getSeasonYearStart(),
                savedPlayerStats.getSeasonYearEnd(),
                savedPlayerStats.getGoals(),
                savedPlayerStats.getAssists(),
                savedPlayerStats.getYellowCards(),
                savedPlayerStats.getRedCards(),
                savedPlayerStats.getStartDate(),
                savedPlayerStats.getEndDate());
    }

    @Override
    public void updateGoalsStats(int playerId, int goals) {
        Optional<PlayerStats> optionalPlayerStats = playerStatsRepository.findByPlayer_Id(playerId);

        if (optionalPlayerStats.isPresent()) {
            PlayerStats playerStats = optionalPlayerStats.get();

            playerStats.setGoals(playerStats.getGoals() + goals);

            playerStatsRepository.save(playerStats);
        } else {
            throw new EntityNotFoundException("Player stats for player ID " + playerId + " not found.");
        }
    }

    @Override
    public void updateAssistStats(int playerId, int assists) {
        Optional<PlayerStats> optionalPlayerStats = playerStatsRepository.findByPlayer_Id(playerId);
        PlayerStats playerStats = optionalPlayerStats.get();

        playerStats.setAssists(playerStats.getAssists() + assists);

        playerStatsRepository.save(playerStats);
    }

    @Override
    public void yellowCartStats(int playerId, int yellowCart) {
        Optional<PlayerStats> optionalPlayerStats = playerStatsRepository.findByPlayer_Id(playerId);
        PlayerStats playerStats = optionalPlayerStats.get();

        playerStats.setYellowCards(playerStats.getYellowCards() + yellowCart);

        playerStatsRepository.save(playerStats);
    }

    @Override
    public void redCartStats(int playerId, int redCart) {
        Optional<PlayerStats> optionalPlayerStats = playerStatsRepository.findByPlayer_Id(playerId);
        PlayerStats playerStats = optionalPlayerStats.get();

        playerStats.setRedCards(playerStats.getRedCards() + redCart);

        playerStatsRepository.save(playerStats);
    }
}
