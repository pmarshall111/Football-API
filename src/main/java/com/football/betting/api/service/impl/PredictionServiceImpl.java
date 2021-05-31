package com.football.betting.api.service.impl;

import com.football.betting.api.datasource.repository.PredictionRepository;
import com.football.betting.api.service.DateHelper;
import com.football.betting.api.service.PredictionService;
import com.football.betting.api.shared.dto.GameDto;
import com.football.betting.api.shared.dto.PredictionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    @Autowired
    PredictionRepository predictionRepository;

    @Override
    public List<PredictionDto> getFuturePredictions() {
        List<Object[]> futurePreds = predictionRepository.findAllFuture(DateHelper.getSqlDate(new Date()));
        ArrayList<PredictionDto> toReturn = new ArrayList<>();
        for (Object[] predObj: futurePreds) {
            PredictionDto pDto = new PredictionDto();
            pDto.setHomePred((double) predObj[0]);
            pDto.setDrawPred((double) predObj[1]);
            pDto.setAwayPred((double) predObj[2]);
            pDto.setHomeOdds((double) predObj[3]);
            pDto.setDrawOdds((double) predObj[4]);
            pDto.setAwayOdds((double) predObj[5]);
            pDto.setOddsFrom((String) predObj[6]);
            pDto.setPredictionUsesLineups((boolean) predObj[7]);
            GameDto gameDto = new GameDto();
            gameDto.setKickOff(DateHelper.createDateFromSQL((String) predObj[8]));
            gameDto.setHomeTeam((String) predObj[9]);
            gameDto.setAwayTeam((String) predObj[10]);
            pDto.setGame(gameDto);
            toReturn.add(pDto);
        }
        return toReturn;
    }
}
