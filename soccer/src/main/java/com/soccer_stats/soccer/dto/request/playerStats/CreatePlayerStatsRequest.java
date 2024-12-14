package com.soccer_stats.soccer.dto.request.playerStats;

import com.soccer_stats.soccer.model.Player;
import jakarta.persistence.*;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerStatsRequest {

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
