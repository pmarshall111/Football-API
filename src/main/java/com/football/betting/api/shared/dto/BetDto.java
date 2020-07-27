package com.football.betting.api.shared.dto;

import java.io.Serializable;

public class BetDto implements Serializable {
    private static final long serialVersionUID = 6832290128765454280L;
    private String resultBetOn;
    private double stake;
    private double oddsWhenBetPlaced;
    private double homeOdds;
    private double drawOdds;
    private double awayOdds;
    private String oddsFrom;
    private GameDto game;

    public String getResultBetOn() {
        return resultBetOn;
    }

    public void setResultBetOn(String resultBetOn) {
        this.resultBetOn = resultBetOn;
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }

    public double getOddsWhenBetPlaced() {
        return oddsWhenBetPlaced;
    }

    public void setOddsWhenBetPlaced(double oddsWhenBetPlaced) {
        this.oddsWhenBetPlaced = oddsWhenBetPlaced;
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

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }
}
