package com.football.betting.api.ui.controller;

import com.football.betting.api.service.PredictionService;
import com.football.betting.api.ui.model.response.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/predictions")
public class PredictionController {
    @Autowired
    PredictionService predictionService;

    @GetMapping
    public List<GameResponse> getFuturePredictions() {
        List<GameResponse> futurePredictions = predictionService.getFuturePredictions();
        futurePredictions.sort(Comparator.comparing(GameResponse::getKickOff));
        return futurePredictions;
    }

}
