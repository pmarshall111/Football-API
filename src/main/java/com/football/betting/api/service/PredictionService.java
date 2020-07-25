package com.football.betting.api.service;

import com.football.betting.api.shared.dto.PredictionDto;

import java.util.List;

public interface PredictionService {
    List<PredictionDto> getFuturePredictions();
}
