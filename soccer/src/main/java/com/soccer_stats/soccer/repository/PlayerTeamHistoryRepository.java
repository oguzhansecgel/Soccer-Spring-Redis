package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.PlayerTeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerTeamHistoryRepository extends JpaRepository<PlayerTeamHistory, Integer> {
}
