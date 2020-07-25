package com.football.betting.api.ui.model.response;

public class PredictionRest {
    private boolean withLineups;
    private HomeDrawAwayRest predictions;
    private HomeDrawAwayRest odds;
    private String oddsFromBookie;
    private GameRest game;

    public GameRest getGame() {
        return game;
    }

    public void setGame(GameRest game) {
        this.game = game;
    }

    public boolean isWithLineups() {
        return withLineups;
    }

    public void setWithLineups(boolean withLineups) {
        this.withLineups = withLineups;
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

    public String getOddsFromBookie() {
        return oddsFromBookie;
    }

    public void setOddsFromBookie(String oddsFromBookie) {
        this.oddsFromBookie = oddsFromBookie;
    }
}
