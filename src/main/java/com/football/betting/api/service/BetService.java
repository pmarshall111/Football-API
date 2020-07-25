package com.football.betting.api.service;

import com.football.betting.api.shared.dto.BetDto;

import java.util.List;

public interface BetService {
    List<BetDto> getHistoricBets();
    List<BetDto> getFutureBets();
}
