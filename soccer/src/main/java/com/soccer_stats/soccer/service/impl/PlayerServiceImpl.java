package com.soccer_stats.soccer.service.impl;

import com.soccer_stats.soccer.dto.request.player.CreatePlayerRequest;
import com.soccer_stats.soccer.dto.request.player.UpdatePlayerRequest;
import com.soccer_stats.soccer.dto.response.player.CreatePlayerResponse;
import com.soccer_stats.soccer.dto.response.player.GetAllPlayerResponse;
import com.soccer_stats.soccer.dto.response.player.GetByIdPlayerResponse;
import com.soccer_stats.soccer.dto.response.player.UpdatePlayerResponse;
import com.soccer_stats.soccer.mapper.PlayerMapping;
import com.soccer_stats.soccer.model.Player;
import com.soccer_stats.soccer.repository.PlayerRepository;
import com.soccer_stats.soccer.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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
        Player player = PlayerMapping.INSTANCE.createPlayer(request);
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
}
