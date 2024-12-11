package com.soccer_stats.soccer.dto.response.team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTeamResponse {
    private int id;
    private String name;
    private int since;
    private String leagueName;
}
