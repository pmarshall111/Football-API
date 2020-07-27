package com.football.betting.api.service.impl;

import com.football.betting.api.io.entity.BetEntity;
import com.football.betting.api.io.repository.BetRepository;
import com.football.betting.api.service.BetService;
import com.football.betting.api.shared.dto.BetDto;
import com.petermarshall.shared.DateHelper;
import org.springframework.beans.BeanUtils;
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
        List<BetEntity> historicBets = betRepository.findAllHistoric(DateHelper.getSqlDate(DateHelper.subtractXminsFromDate(new Date(), 130)));
        ArrayList<BetDto> toReturn = new ArrayList<>();
        for (BetEntity bEnt: historicBets) {
            BetDto bDto = new BetDto();
            BeanUtils.copyProperties(bEnt, bDto);
            toReturn.add(bDto);
        }
        return toReturn;
    }

    @Override
    public List<BetDto> getFutureBets() {
        List<BetEntity> futureBets = betRepository.findAllFuture(DateHelper.getSqlDate(new Date()));
        ArrayList<BetDto> toReturn = new ArrayList<>();
        for (BetEntity bEnt: futureBets) {
            BetDto bDto = new BetDto();
            BeanUtils.copyProperties(bEnt, bDto);
            toReturn.add(bDto);
        }
        return toReturn;
    }
}
