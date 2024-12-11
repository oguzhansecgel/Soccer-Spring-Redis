package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
