package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Integer> {
}
