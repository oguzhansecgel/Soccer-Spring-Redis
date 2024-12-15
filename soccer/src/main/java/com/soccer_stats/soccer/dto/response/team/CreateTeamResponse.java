package com.soccer_stats.soccer.dto.response.team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamResponse {
    private int id;
    private String name;
    private int since;
    private LocalDate seasonStart;
    private LocalDate seasonEnd;
    private int leagueId;
}
