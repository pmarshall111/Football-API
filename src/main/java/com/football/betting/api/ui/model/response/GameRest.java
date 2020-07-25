package com.football.betting.api.ui.model.response;

import java.util.Date;

public class GameRest {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private Date kickOff;

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
