package com.soccer_stats.search_service.service.impl;

import com.soccer_stats.search_service.document.Player;
import com.soccer_stats.search_service.repository.PlayerRepository;
import com.soccer_stats.search_service.service.PlayerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void createPlayer(@Payload Player player) {
        Player playerSearch = new Player();
        playerSearch.setId(player.getId());
        playerSearch.setFirstName(player.getFirstName());
        playerSearch.setLastName(player.getLastName());
        playerSearch.setPosition(player.getPosition());
        playerSearch.setMarketValue(player.getMarketValue());
        playerSearch.setBirthDate(player.getBirthDate());
        playerSearch.setHeight(player.getHeight());
        playerSearch.setWeight(player.getWeight());
        playerSearch.setContractEndDate(player.getContractEndDate());
        playerSearch.setPositions(player.getPositions());
        playerSearch.setCurrentTeamId(player.getCurrentTeamId());
        playerRepository.save(playerSearch);
    }

    @Override
    public Iterable<Player> getPlayers() {
        Iterable<Player> playerList = playerRepository.findAll();
        return playerList;
    }
}
