package com.football.betting.api.ui.controller;

import com.football.betting.api.service.impl.BetServiceImpl;
import com.football.betting.api.shared.dto.BetDto;
import com.football.betting.api.ui.model.response.BetRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    BetServiceImpl betService;

    @GetMapping(path="/historic")
    public List<BetRest> getHistoricBets() {
        ArrayList<BetRest> returnObj = new ArrayList<>();
        List<BetDto> betsDto = betService.getHistoricBets();
        for (BetDto bDto: betsDto) {
            BetRest bRest = new BetRest();
            BeanUtils.copyProperties(bDto, bRest);
            returnObj.add(bRest);
        }
        return returnObj;
    }

    @GetMapping(path="/future")
    public List<BetRest> getFutureBets() {
        ArrayList<BetRest> returnObj = new ArrayList<>();
        List<BetDto> betsDto = betService.getFutureBets();
        for (BetDto bDto: betsDto) {
            BetRest bRest = new BetRest();
            BeanUtils.copyProperties(bDto, bRest);
            returnObj.add(bRest);
        }
        return returnObj;
    }

}
