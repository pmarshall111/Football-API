package com.football.betting.api.ui.model.response;

public class BetResponse {
    private int resultBetOn;
    private double stake;
    private double odds;
    private boolean isLayBet;
    private double liability;

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

    public boolean isLayBet() {
        return isLayBet;
    }

    public void setLayBet(boolean layBet) {
        isLayBet = layBet;
    }

    public double getLiability() {
        return liability;
    }

    public void setLiability(double liability) {
        this.liability = liability;
    }
}
