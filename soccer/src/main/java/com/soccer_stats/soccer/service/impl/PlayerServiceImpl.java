package com.soccer_stats.soccer.service.impl;

import com.soccer_stats.soccer.dto.request.player.CreatePlayerRequest;
import com.soccer_stats.soccer.dto.request.player.UpdatePlayerRequest;
import com.soccer_stats.soccer.dto.response.player.*;
import com.soccer_stats.soccer.mapper.PlayerMapping;
import com.soccer_stats.soccer.model.Player;
import com.soccer_stats.soccer.model.Team;
import com.soccer_stats.soccer.repository.PlayerRepository;
import com.soccer_stats.soccer.repository.TeamRepository;
import com.soccer_stats.soccer.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<GetByIdPlayerResponse> getByIdPlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(PlayerMapping.INSTANCE::getById);
    }

    @Override
    public List<GetAllPlayerResponse> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return PlayerMapping.INSTANCE.getAllPlayerToList(players);
    }

    @Override
    public CreatePlayerResponse createPlayer(CreatePlayerRequest request) {
        Team currentTeam = teamRepository.findById(request.getCurrentTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        Player player = PlayerMapping.INSTANCE.createPlayer(request);
        player.setCurrentTeam(currentTeam);

        double newSquadValue = currentTeam.getSquadValue() + request.getMarketValue();
        currentTeam.setSquadValue(newSquadValue);

        teamRepository.save(currentTeam);
        Player savedPlayer = playerRepository.save(player);
        return new CreatePlayerResponse(savedPlayer.getId(),
                savedPlayer.getFirstName(),
                savedPlayer.getLastName(),
                savedPlayer.getPosition(),
                savedPlayer.getBirthDate(),
                savedPlayer.getHeight(),
                savedPlayer.getWeight(),
                savedPlayer.getMarketValue(),
                savedPlayer.getContractEndDate(),
                savedPlayer.getPositions(),
                savedPlayer.getCurrentTeam().getId());
    }

    @Override
    public UpdatePlayerResponse updatePlayer(UpdatePlayerRequest request, int id) {
        Player player = playerRepository.findById(id).get();
        Player player1 = PlayerMapping.INSTANCE.updatePlayer(request, player);
        Player savedPlayer = playerRepository.save(player);
        return new UpdatePlayerResponse(
                savedPlayer.getId(),
                savedPlayer.getFirstName(),
                savedPlayer.getLastName(),
                savedPlayer.getPosition(),
                savedPlayer.getBirthDate(),
                savedPlayer.getHeight(),
                savedPlayer.getWeight(),
                savedPlayer.getMarketValue(),
                savedPlayer.getContractEndDate(),
                savedPlayer.getPositions(),
                savedPlayer.getCurrentTeam().getId()
        );
    }

    @Override
    public List<GetAllPlayerWithTeam> getAllPlayersWithTeam(int teamId) {
        List<Player> players = playerRepository.findByCurrentTeamId(teamId);
        return PlayerMapping.INSTANCE.getAllPlayerWithTeamToList(players);
    }

    @Override
    public void transferPlayer(int playerId, int fromTeamId, int toTeamId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        Optional<Team> fromTeamOptional = teamRepository.findById(fromTeamId);
        Optional<Team> toTeamOptional = teamRepository.findById(toTeamId);



        Player player = playerOptional.get();
        Team fromTeam = fromTeamOptional.get();
        Team toTeam = toTeamOptional.get();

        double currentSquadValue = fromTeam.getSquadValue();
        double playerMarketValue = player.getMarketValue();
        double newSquadValueFromTeam = currentSquadValue - playerMarketValue;
        fromTeam.setSquadValue(newSquadValueFromTeam);

        double currentSquadValueToTeam = toTeam.getSquadValue();
        double newSquadValueToTeam = currentSquadValueToTeam + playerMarketValue;
        toTeam.setSquadValue(newSquadValueToTeam);

        player.setCurrentTeam(toTeam);

        teamRepository.save(fromTeam);
        teamRepository.save(toTeam);
        playerRepository.save(player);
    }

}
