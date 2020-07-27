package com.football.betting.api.ui.model.response;

public class BetRest {
    private String resultBetOn;
    private double stake;
    private double oddsWhenBetPlaced;
    private HomeDrawAwayRest odds;
    private String oddsFrom;
    private GameRest game;

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

    public HomeDrawAwayRest getOdds() {
        return odds;
    }

    public void setOdds(HomeDrawAwayRest odds) {
        this.odds = odds;
    }

    public String getOddsFrom() {
        return oddsFrom;
    }

    public void setOddsFrom(String oddsFrom) {
        this.oddsFrom = oddsFrom;
    }

    public GameRest getGame() {
        return game;
    }

    public void setGame(GameRest game) {
        this.game = game;
    }
}
