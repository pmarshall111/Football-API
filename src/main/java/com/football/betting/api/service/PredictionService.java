package com.football.betting.api.service;

import com.football.betting.api.datasource.entity.BetEntity;
import com.football.betting.api.datasource.entity.GameEntity;
import com.football.betting.api.datasource.entity.PredictionEntity;
import com.football.betting.api.datasource.repository.GameRepository;
import com.football.betting.api.datasource.repository.PredictionRepository;
import com.football.betting.api.shared.DateHelper;
import com.football.betting.api.shared.PredictionHelper;
import com.football.betting.api.ui.model.response.BetResponse;
import com.football.betting.api.ui.model.response.GameResponse;
import com.football.betting.api.ui.model.response.HomeDrawAway;
import com.football.betting.api.ui.model.response.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PredictionService {
    @Autowired GameRepository gameRepository;

    public List<GameResponse> getFuturePredictions() {
        Date twoWeeksAhead = DateHelper.addXDaysToDate(new Date(), 14);
        List<GameEntity> futureGames =  gameRepository.findAllByDateGreaterThanAndDateLessThan(DateHelper.getSqlDate(new Date()), DateHelper.getSqlDate(twoWeeksAhead));

        ArrayList<GameResponse> futureGamesWithPredictions = new ArrayList<>();

        futureGames.forEach(game -> {
            PredictionEntity predictionToUse = PredictionHelper.getBestPrediction(game.getPredictions());
            if (predictionToUse != null) {
                GameResponse gameResp = new GameResponse();
                PredictionResponse predResp = PredictionHelper.convertPredictionEntityToResponse(predictionToUse);
                gameResp.setPrediction(predResp);
                gameResp.setHomeTeam(game.getHomeTeam());
                gameResp.setAwayTeam(game.getAwayTeam());
                gameResp.setHomeTeam(game.getHomeTeam());
                gameResp.setAwayTeam(game.getAwayTeam());
                gameResp.setKickOff(game.getDate());
                gameResp.setLeague(game.getLeague());

                BetEntity bet = game.getBet();
                if (bet != null) {
                    BetResponse betResp = new BetResponse();
                    betResp.setResultBetOn(bet.getResultBetOn());
                    betResp.setStake(bet.getStake());
                    betResp.setOdds(bet.getOdds());
                    gameResp.setBet(betResp);
                }
                futureGamesWithPredictions.add(gameResp);
            }
        });
        return futureGamesWithPredictions;
    }
}
