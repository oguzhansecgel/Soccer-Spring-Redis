package com.soccer_stats.search_service.service;

import com.soccer_stats.search_service.document.Player;

import java.util.List;

public interface PlayerService {
    void createPlayer(Player player);
    Iterable<Player> getPlayers();
}
