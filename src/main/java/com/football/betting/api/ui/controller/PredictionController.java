package com.football.betting.api.ui.controller;

import com.football.betting.api.service.impl.PredictionServiceImpl;
import com.football.betting.api.shared.dto.BetDto;
import com.football.betting.api.shared.dto.PredictionDto;
import com.football.betting.api.ui.model.response.BetRest;
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
        ArrayList<PredictionRest> returnObj = new ArrayList<>();
        List<PredictionDto> predsDto = predictionService.getFuturePredictions();
        for (PredictionDto pDto: predsDto) {
            PredictionRest pRest = new PredictionRest();
            BeanUtils.copyProperties(pDto, pRest);
            returnObj.add(pRest);
        }
        return returnObj;
    }

}
