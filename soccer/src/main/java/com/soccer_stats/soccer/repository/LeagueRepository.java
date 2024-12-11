package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Integer> {
}
