package com.football.betting.api.ui.model.response;

import com.football.betting.api.datasource.entity.GameEntity;
import com.football.betting.api.datasource.entity.PredictionEntity;

public class BetResponse {
    private int resultBetOn;
    private double stake;
    private double odds;

    public int getResultBetOn() {
        return resultBetOn;
    }

    public void setResultBetOn(int resultBetOn) {
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
}
