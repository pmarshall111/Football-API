package com.football.betting.api;

import com.football.betting.api.datasource.entity.PredictionEntity;
import com.football.betting.api.shared.DateHelper;
import com.football.betting.api.service.BetService;
import com.football.betting.api.shared.PredictionHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredictionHelperTest {
    @Test
    public void canChoosePredictionWithLineupsAsBestPrediction() {
        ArrayList<PredictionEntity> preds = new ArrayList<>();

        PredictionEntity noLineups = new PredictionEntity();
        noLineups.setDate(DateHelper.getSqlDate(new Date()));
        noLineups.setWithLineups(false);

        PredictionEntity withLineups = new PredictionEntity();
        String dateToCheckFor = DateHelper.getSqlDate(DateHelper.createDateyyyyMMdd("2020","08","26"));
        withLineups.setDate(dateToCheckFor);
        withLineups.setWithLineups(true);

        preds.add(noLineups);
        preds.add(withLineups);

        PredictionEntity bestPred = PredictionHelper.getBestPrediction(preds);
        assertEquals(DateHelper.createDateFromSQL(dateToCheckFor), bestPred.getDate()); //getDate method calls this method.
        assertTrue(bestPred.isWithLineups());
    }

    @Test
    public void canGetLatestPredictionAsBestPrediction() {
        ArrayList<PredictionEntity> preds = new ArrayList<>();

        PredictionEntity latest = new PredictionEntity();
        String dateToCheckFor = DateHelper.getSqlDate(new Date());
        latest.setDate(dateToCheckFor);
        latest.setWithLineups(false);

        PredictionEntity previous = new PredictionEntity();
        previous.setDate(DateHelper.getSqlDate(DateHelper.createDateyyyyMMdd("2020","08","26")));
        previous.setWithLineups(false);

        preds.add(previous);
        preds.add(latest);

        PredictionEntity bestPred = PredictionHelper.getBestPrediction(preds);
        assertEquals(DateHelper.createDateFromSQL(dateToCheckFor), bestPred.getDate()); //getDate method calls this method.
    }
}
