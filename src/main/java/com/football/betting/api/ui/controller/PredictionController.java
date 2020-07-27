package com.football.betting.api.ui.controller;

import com.football.betting.api.service.impl.PredictionServiceImpl;
import com.football.betting.api.shared.dto.BetDto;
import com.football.betting.api.shared.dto.PredictionDto;
import com.football.betting.api.ui.model.response.BetRest;
import com.football.betting.api.ui.model.response.GameRest;
import com.football.betting.api.ui.model.response.HomeDrawAwayRest;
import com.football.betting.api.ui.model.response.PredictionRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/predict")
public class PredictionController {
    @Autowired
    PredictionServiceImpl predictionService;

    @GetMapping(path="/all")
    public List<PredictionRest> getFuturePredictions() {
        System.out.println("Calling get all future predictions");
        ArrayList<PredictionRest> returnObj = new ArrayList<>();
        List<PredictionDto> predsDto = predictionService.getFuturePredictions();
        for (PredictionDto pDto: predsDto) {
            PredictionRest pRest = new PredictionRest();
            pRest.setOdds(new HomeDrawAwayRest(pDto.getHomeOdds(), pDto.getDrawOdds(), pDto.getAwayOdds()));
            pRest.setPredictions(new HomeDrawAwayRest(pDto.getHomePred(), pDto.getDrawPred(), pDto.getAwayPred()));
            BeanUtils.copyProperties(pDto, pRest);
            GameRest gameRest = new GameRest();
            BeanUtils.copyProperties(pDto.getGame(), gameRest);
            pRest.setGame(gameRest);
            returnObj.add(pRest);
        }
        return returnObj;
    }

}
