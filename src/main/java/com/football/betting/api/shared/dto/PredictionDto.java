package com.football.betting.api.shared.dto;

import java.io.Serializable;

public class PredictionDto implements Serializable {
    private static final long serialVersionUID = 219856389216128142L;

    private boolean predictionUsesLineups;
    private double homePred;
    private double drawPred;
    private double awayPred;
    private double homeOdds;
    private double drawOdds;
    private double awayOdds;
    private String oddsFrom;
    private GameDto game;

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }

    public boolean isPredictionUsesLineups() {
        return predictionUsesLineups;
    }

    public void setPredictionUsesLineups(boolean predictionUsesLineups) {
        this.predictionUsesLineups = predictionUsesLineups;
    }

    public double getHomePred() {
        return homePred;
    }

    public void setHomePred(double homePred) {
        this.homePred = homePred;
    }

    public double getDrawPred() {
        return drawPred;
    }

    public void setDrawPred(double drawPred) {
        this.drawPred = drawPred;
    }

    public double getAwayPred() {
        return awayPred;
    }

    public void setAwayPred(double awayPred) {
        this.awayPred = awayPred;
    }

    public double getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(double homeOdds) {
        this.homeOdds = homeOdds;
    }

    public double getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(double drawOdds) {
        this.drawOdds = drawOdds;
    }

    public double getAwayOdds() {
        return awayOdds;
    }

    public void setAwayOdds(double awayOdds) {
        this.awayOdds = awayOdds;
    }

    public String getOddsFrom() {
        return oddsFrom;
    }

    public void setOddsFrom(String oddsFrom) {
        this.oddsFrom = oddsFrom;
    }
}
