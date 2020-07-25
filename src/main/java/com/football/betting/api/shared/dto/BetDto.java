package com.football.betting.api.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class BetDto implements Serializable {
    private static final long serialVersionUID = 6832290128765454280L;
    private double stake;
    private double odds;
    private GameDto game;

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

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }
}
