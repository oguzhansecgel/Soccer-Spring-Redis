package com.soccer_stats.soccer.dto.request.team;
import com.soccer_stats.soccer.model.League;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamRequest {
    private String name;
    private int since;
    private int leagueId;
}