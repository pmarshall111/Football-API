package com.football.betting.api.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class GameDto implements Serializable {
    private static final long serialVersionUID = 90213898901298570L;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private Date kickOff;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
