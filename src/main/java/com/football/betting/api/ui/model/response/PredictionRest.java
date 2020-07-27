package com.football.betting.api.ui.model.response;

public class PredictionRest {
    private boolean predictionUsesLineups;
    private HomeDrawAwayRest predictions;
    private HomeDrawAwayRest odds;
    private String oddsFrom;
    private GameRest game;

    public GameRest getGame() {
        return game;
    }

    public void setGame(GameRest game) {
        this.game = game;
    }

    public boolean isPredictionUsesLineups() {
        return predictionUsesLineups;
    }

    public void setPredictionUsesLineups(boolean predictionUsesLineups) {
        this.predictionUsesLineups = predictionUsesLineups;
    }

    public HomeDrawAwayRest getPredictions() {
        return predictions;
    }

    public void setPredictions(HomeDrawAwayRest predictions) {
        this.predictions = predictions;
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
}
