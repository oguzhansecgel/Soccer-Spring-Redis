package com.soccer_stats.soccer.repository;

import com.soccer_stats.soccer.dto.response.team.GetAllTeamWithLeague;
import com.soccer_stats.soccer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByLeague_Id(int leagueId);
}
