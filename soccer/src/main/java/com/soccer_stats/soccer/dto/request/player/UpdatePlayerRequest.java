package com.soccer_stats.soccer.dto.request.player;
import com.soccer_stats.soccer.model.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlayerRequest {
    private String firstName;
    private String lastName;
    private Position position;
    private Date birthDate;
    private double height;
    private double weight;
    private double marketValue;
    private Date contractEndDate;

    private Set<Position> positions;

    private int currentTeamId;

    private List<Integer> teamsId;
}
