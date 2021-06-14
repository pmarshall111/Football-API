package com.football.betting.api.datasource.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name="game")
public class GameEntity {
    private static final long serialVersionUID = 1224918294727812391L;

    @Id
    private int _id;

    @ManyToOne
    @JoinColumn(name="homeTeam_id")
    private TeamEntity homeTeam;
    @ManyToOne
    @JoinColumn(name="awayTeam_id")
    private TeamEntity awayTeam;
    @Column
    private int homeScore;
    @Column
    private int awayScore;
    @Column(columnDefinition = "text")
    private String date;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getHomeTeam() {
        return homeTeam.getName();
    }

    public void setHomeTeam(TeamEntity homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam.getName();
    }

    public void setAwayTeam(TeamEntity awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeague() {
        return this.homeTeam.getLeague().getName();
    }
}

