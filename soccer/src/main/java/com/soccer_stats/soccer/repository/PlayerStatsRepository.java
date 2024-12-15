package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.Player;
import com.soccer_stats.soccer.model.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Integer> {
    Optional<PlayerStats> findByPlayer_Id(int playerId);
    List<PlayerStats> findByPlayerId(int playerId);
}
