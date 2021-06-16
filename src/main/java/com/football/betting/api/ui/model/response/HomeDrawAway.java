package com.football.betting.api.ui.model.response;

public class HomeDrawAway {
    private double home;
    private double draw;
    private double away;

    public HomeDrawAway(double home, double draw, double away) {
        this.home = home;
        this.draw = draw;
        this.away = away;
    }

    public double getHome() {
        return home;
    }

    public void setHome(double home) {
        this.home = home;
    }

    public double getDraw() {
        return draw;
    }

    public void setDraw(double draw) {
        this.draw = draw;
    }

    public double getAway() {
        return away;
    }

    public void setAway(double away) {
        this.away = away;
    }
}
