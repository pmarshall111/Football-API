package com.football.betting.api.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "prediction")
public class PredictionEntity implements Serializable {
    private static final long serialVersionUID = 2881263728946359121L;

    @Id
    private int id;
    @Column
    private double homePred;
    @Column
    private double drawPred;
    @Column
    private double awayPred;
    @Column
    private double homeOdds;
    @Column
    private double drawOdds;
    @Column
    private double awayOdds;
    @Column
    private String bookie;
    @Column
    private boolean withLineups;
    @ManyToOne
    private GameEntity game;

    public int getId() {
        return id;
    }

    public double getHomePred() {
        return homePred;
    }

    public void setHomePred(double homePred) {
        this.homePred = homePred;
    }

    public double getDrawPred() {
        return drawPred;
    }

    public void setDrawPred(double drawPred) {
        this.drawPred = drawPred;
    }

    public double getAwayPred() {
        return awayPred;
    }

    public void setAwayPred(double awayPred) {
        this.awayPred = awayPred;
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

    public String getBookie() {
        return bookie;
    }

    public void setBookie(String bookie) {
        this.bookie = bookie;
    }

    public boolean isWithLineups() {
        return withLineups;
    }

    public void setWithLineups(boolean withLineups) {
        this.withLineups = withLineups;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
