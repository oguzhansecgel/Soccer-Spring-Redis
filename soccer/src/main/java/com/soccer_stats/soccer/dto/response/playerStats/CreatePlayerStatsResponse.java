package com.soccer_stats.soccer.dto.response.playerStats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerStatsResponse {

    private int id;

    private int playerId;

    private int seasonYearStart;
    private int seasonYearEnd;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private Date startDate;
    private Date endDate;
}
