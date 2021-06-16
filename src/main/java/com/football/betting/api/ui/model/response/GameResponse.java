package com.football.betting.api.ui.model.response;

import java.util.Date;

public class GameResponse {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private Date kickOff;
    private PredictionResponse prediction;
    private BetResponse bet;

    public PredictionResponse getPrediction() {
        return prediction;
    }

    public void setPrediction(PredictionResponse prediction) {
        this.prediction = prediction;
    }

    public BetResponse getBet() {
        return bet;
    }

    public void setBet(BetResponse bet) {
        this.bet = bet;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
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

    public Date getKickOff() {
        return kickOff;
    }

    public void setKickOff(Date kickOff) {
        this.kickOff = kickOff;
    }
}
