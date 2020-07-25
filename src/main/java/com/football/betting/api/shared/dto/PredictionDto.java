package com.football.betting.api.shared.dto;

import com.football.betting.api.ui.model.response.HomeDrawAwayRest;

import java.io.Serializable;

public class PredictionDto implements Serializable {
    private static final long serialVersionUID = 219856389216128142L;

    private boolean withLineups;
    private double homePred;
    private double drawPred;
    private double awayPred;
    private double homeOdds;
    private double drawOdds;
    private double awayOdds;
    private String oddsFromBookie;


}
