package com.football.betting.api.ui.model.response;

import java.util.Date;

public class BetRest {
    private double resultBetOn;
    private double stake;
    private double odds;
    private GameRest game;

    public double getResultBetOn() {
        return resultBetOn;
    }

    public void setResultBetOn(double resultBetOn) {
        this.resultBetOn = resultBetOn;
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public GameRest getGame() {
        return game;
    }

    public void setGame(GameRest game) {
        this.game = game;
    }
}
