package com.football.betting.api.datasource.entity;

import com.football.betting.api.shared.DateHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "match_id")
    private List<PredictionEntity> predictions;

    @OneToMany
    @JoinColumn(name="match_id")
    private List<BetEntity> bet;

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

    public Date getDate() {
        return DateHelper.createDateFromSQL(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeague() {
        return this.homeTeam.getLeague().getName();
    }

    public ArrayList<PredictionEntity> getPredictions() {
        return new ArrayList<>(predictions);
    }

    public void setPredictions(List<PredictionEntity> predictions) {
        this.predictions = predictions;
    }

    public List<BetEntity> getBet() {
        return bet;
    }

    public void setBet(List<BetEntity> bet) {
        this.bet = bet;
    }
}

