package com.football.betting.api.ui.model.response;

public class PredictionResponse {
    private boolean predictionUsesLineups;
    private HomeDrawAway predictions;
    private HomeDrawAway bookiePredictions;
    private HomeDrawAway bookieOdds;

    public boolean isPredictionUsesLineups() {
        return predictionUsesLineups;
    }

    public void setPredictionUsesLineups(boolean predictionUsesLineups) {
        this.predictionUsesLineups = predictionUsesLineups;
    }

    public HomeDrawAway getPredictions() {
        return predictions;
    }

    public void setPredictions(HomeDrawAway predictions) {
        this.predictions = predictions;
    }

    public HomeDrawAway getBookiePredictions() {
        return bookiePredictions;
    }

    public void setBookiePredictions(HomeDrawAway bookiePredictions) {
        this.bookiePredictions = bookiePredictions;
    }

    public HomeDrawAway getBookieOdds() {
        return bookieOdds;
    }

    public void setBookieOdds(HomeDrawAway bookieOdds) {
        this.bookieOdds = bookieOdds;
    }
}
