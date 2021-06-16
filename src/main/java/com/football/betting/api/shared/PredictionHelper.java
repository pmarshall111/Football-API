package com.football.betting.api.shared;

import com.football.betting.api.datasource.entity.PredictionEntity;
import com.football.betting.api.ui.model.response.HomeDrawAway;
import com.football.betting.api.ui.model.response.PredictionResponse;

import java.util.ArrayList;

public class PredictionHelper {
    public static PredictionResponse convertPredictionEntityToResponse(PredictionEntity predEnt) {
        PredictionResponse predResp = new PredictionResponse();
        predResp.setPredictionUsesLineups(predEnt.isWithLineups());
        predResp.setBookieOdds(new HomeDrawAway(predEnt.getHomeOdds(), predEnt.getDrawOdds(), predEnt.getAwayOdds()));
        predResp.setBookiePredictions(new HomeDrawAway(1/predEnt.getHomeOdds(), 1/predEnt.getDrawOdds(), 1/predEnt.getAwayOdds()));
        predResp.setPredictions(new HomeDrawAway(predEnt.getHomePred(), predEnt.getDrawPred(), predEnt.getAwayPred()));
        return predResp;
    }

    public static PredictionEntity getBestPrediction(ArrayList<PredictionEntity> allPreds) {
        if (allPreds.size() == 0) {
            return null;
        }
        allPreds.sort((p1, p2) -> {
            if (p1.isWithLineups() == p2.isWithLineups()) {
                return p1.getDate().before(p2.getDate()) ? 1 : -1;
            } else if (p1.isWithLineups()) {
                return -1;
            } else {
                return 1;
            }
        });
        return allPreds.get(0);
    }
}
