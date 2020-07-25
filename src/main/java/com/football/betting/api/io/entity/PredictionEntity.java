package com.football.betting.api.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "prediction")
public class PredictionEntity implements Serializable {
    private static final long serialVersionUID = 2881263728946359121L;

    @Id
    private long id;
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

}
