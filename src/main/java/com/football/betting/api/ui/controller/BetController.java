package com.football.betting.api.ui.controller;

import com.football.betting.api.service.BetService;
import com.football.betting.api.ui.model.response.GameResponse;
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
    BetService betService;

    @GetMapping
    public List<GameResponse> getHistoricBets() {
        List<GameResponse> historicBets = betService.getHistoricBets();
        historicBets.sort((g1, g2) -> {
            return g1.getKickOff().compareTo(g2.getKickOff());
        });
        return historicBets;
    }

}
