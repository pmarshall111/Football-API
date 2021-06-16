package com.football.betting.api.service;

import com.football.betting.api.datasource.entity.BetEntity;
import com.football.betting.api.datasource.entity.GameEntity;
import com.football.betting.api.datasource.entity.PredictionEntity;
import com.football.betting.api.datasource.repository.BetRepository;
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
public class BetService {
    @Autowired
    BetRepository betRepository;

    public List<GameResponse> getHistoricBets() {
        ArrayList<GameResponse> historicGamesWithBets = new ArrayList<>();

        Iterable<BetEntity> allBets = betRepository.findAll();
        allBets.forEach(bet -> {
            GameEntity game = bet.getGame();
            if (game.getDate().before(new Date())) {
                GameResponse gameResp = new GameResponse();

                BetResponse betResp = new BetResponse();
                betResp.setResultBetOn(bet.getResultBetOn());
                betResp.setStake(bet.getStake());
                betResp.setOdds(bet.getOdds());

                PredictionEntity predictionToUse = PredictionHelper.getBestPrediction(new ArrayList<>(bet.getGame().getPredictions()));
                if (predictionToUse != null) {
                    PredictionResponse predResp = new PredictionResponse();
                    predResp.setPredictionUsesLineups(predictionToUse.isWithLineups());
                    predResp.setBookieOdds(new HomeDrawAway(predictionToUse.getHomeOdds(), predictionToUse.getDrawOdds(), predictionToUse.getAwayOdds()));
                    predResp.setBookiePredictions(new HomeDrawAway(1/predictionToUse.getHomeOdds(), 1/predictionToUse.getDrawOdds(), 1/predictionToUse.getAwayOdds()));
                    predResp.setPredictions(new HomeDrawAway(predictionToUse.getHomePred(), predictionToUse.getDrawPred(), predictionToUse.getAwayPred()));
                    gameResp.setPrediction(predResp);
                }

                gameResp.setHomeTeam(game.getHomeTeam());
                gameResp.setAwayTeam(game.getAwayTeam());
                gameResp.setHomeTeam(game.getHomeTeam());
                gameResp.setAwayTeam(game.getAwayTeam());
                gameResp.setKickOff(game.getDate());
                gameResp.setBet(betResp);

                historicGamesWithBets.add(gameResp);
            }
        });

        return historicGamesWithBets;
    }

}
