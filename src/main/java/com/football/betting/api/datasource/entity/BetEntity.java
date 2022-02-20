package com.football.betting.api.datasource.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="bet")
@IdClass(BetEntity.class)
public class BetEntity implements Serializable {

    private static final long serialVersionUID = 29671229032852283L;

    @Column
    private double stake;

    @Column
    private double odds;

    @Column
    private int resultBetOn;

    @Column
    @Id
    private boolean isLayBet;

    @ManyToOne
    @JoinColumn(name="match_id", insertable = false, updatable = false)
    private GameEntity game;

    @Column
    @Id
    private int match_id;

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

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public int getResultBetOn() {
        return resultBetOn;
    }

    public void setResultBetOn(int resultBetOn) {
        this.resultBetOn = resultBetOn;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public boolean isLayBet() {
        return isLayBet;
    }

    public void setLayBet(boolean layBet) {
        isLayBet = layBet;
    }
}
