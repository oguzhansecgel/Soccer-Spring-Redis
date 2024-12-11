package com.soccer_stats.soccer.dto.response.league;
import com.soccer_stats.soccer.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLeagueResponse {
    private int id;
    private String leagueName;
    private int startDate;
    private int endDate;
    private Country country;
}
