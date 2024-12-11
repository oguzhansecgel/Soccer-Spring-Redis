package com.soccer_stats.soccer.dto.request.team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTeamRequest {
    private String name;
    private int since;
    private int leagueId;
}
