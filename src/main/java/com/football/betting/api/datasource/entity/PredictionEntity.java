package com.football.betting.api.datasource.entity;

import com.football.betting.api.shared.DateHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

class PredictionEntityId implements Serializable {
    private static final long serialVersionUID = 288126372821983921L;

    private int match_id;
    private boolean withLineups;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public boolean isWithLineups() {
        return withLineups;
    }

    public void setWithLineups(boolean withLineups) {
        this.withLineups = withLineups;
    }
}

@Entity(name = "prediction")
@IdClass(PredictionEntityId.class)
public class PredictionEntity implements Serializable {
    private static final long serialVersionUID = 2881263728946359121L;

    @Column(columnDefinition = "text")
    private String date;
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
    @Column(columnDefinition = "text")
    private String bookie;
    @Column
    @Id
    private boolean withLineups;
    @ManyToOne
    @JoinColumn(name="match_id", insertable = false, updatable = false)
    private GameEntity game;

    @Column
    @Id
    private int match_id;

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

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Date getDate() {
        return DateHelper.createDateFromSQL(date);
    }

    public void setDate(String date) {
        this.date = date;
    }
}
