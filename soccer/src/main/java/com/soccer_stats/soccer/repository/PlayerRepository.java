package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
