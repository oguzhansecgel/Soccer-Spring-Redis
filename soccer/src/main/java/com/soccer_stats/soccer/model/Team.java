package com.soccer_stats.soccer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int since;
    private double squadValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate seasonStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate seasonEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "currentTeam",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;
}