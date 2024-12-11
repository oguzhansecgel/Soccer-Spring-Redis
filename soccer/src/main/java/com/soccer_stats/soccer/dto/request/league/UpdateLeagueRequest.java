package com.soccer_stats.soccer.dto.request.league;
import com.soccer_stats.soccer.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLeagueRequest {
    private String leagueName;
    private int startDate;
    private int endDate;
    private Country country;
}
