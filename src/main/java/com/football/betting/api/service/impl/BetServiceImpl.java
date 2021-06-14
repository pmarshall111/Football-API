package com.football.betting.api.service.impl;

import com.football.betting.api.datasource.repository.BetRepository;
import com.football.betting.api.service.BetService;
import com.football.betting.api.service.DateHelper;
import com.football.betting.api.shared.dto.BetDto;
import com.football.betting.api.shared.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BetServiceImpl implements BetService {
    @Autowired
    BetRepository betRepository;

    @Override
    public List<BetDto> getHistoricBets() {
        List<Object[]> historicBets = betRepository.findAllHistoric(DateHelper.getSqlDate(DateHelper.subtractXminsFromDate(new Date(), 130)));
        return convertBetObjsToList(historicBets);
    }

    @Override
    public List<BetDto> getFutureBets() {
        List<Object[]> futureBets = betRepository.findAllFuture(DateHelper.getSqlDate(new Date()));
        return convertBetObjsToList(futureBets);
    }

    private ArrayList<BetDto> convertBetObjsToList(List<Object[]> betObjList) {
        ArrayList<BetDto> toReturn = new ArrayList<>();
        for (Object[] betObj: betObjList) {
            BetDto bDto = new BetDto();
            double resultBetOn = (int) betObj[0];
            String resultBetOnString = "null";
            if (resultBetOn == 0) {
                resultBetOnString = "home";
            } else if (resultBetOn == 1) {
                resultBetOnString = "draw";
            } else if (resultBetOn == 2) {
                resultBetOnString = "away";
            }
            bDto.setResultBetOn(resultBetOnString);
            bDto.setOddsWhenBetPlaced((double) betObj[1]);
            bDto.setStake((double) betObj[2]);
            bDto.setHomeOdds((double) betObj[3]);
            bDto.setDrawOdds((double) betObj[4]);
            bDto.setAwayOdds((double) betObj[5]);
            bDto.setOddsFrom("Bet 365"); //odds stored in Match db are always from Bet365.
            GameDto gameDto = new GameDto();
            gameDto.setKickOff(DateHelper.createDateFromSQL((String) betObj[6]));
            gameDto.setHomeTeam((String) betObj[7]);
            gameDto.setAwayTeam((String) betObj[8]);
            gameDto.setHomeScore((int) betObj[9]);
            gameDto.setAwayScore((int) betObj[10]);
            bDto.setGame(gameDto);

            toReturn.add(bDto);
        }
        return toReturn;
    }
}
