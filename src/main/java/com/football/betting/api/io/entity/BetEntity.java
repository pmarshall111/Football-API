package com.football.betting.api.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Bet")
public class BetEntity implements Serializable {

    private static final long serialVersionUID = 29671229032852283L;

    @Id
    private long id;

    @Column
    private double stake;

    @Column
    private double odds;

    @ManyToOne
    private GameEntity game;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
