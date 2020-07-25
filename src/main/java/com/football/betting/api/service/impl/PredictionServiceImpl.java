package com.football.betting.api.service.impl;

import com.football.betting.api.io.entity.BetEntity;
import com.football.betting.api.io.entity.PredictionEntity;
import com.football.betting.api.io.repository.PredictionRepository;
import com.football.betting.api.service.PredictionService;
import com.football.betting.api.shared.dto.BetDto;
import com.football.betting.api.shared.dto.PredictionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    @Autowired
    PredictionRepository predictionRepository;

    @Override
    public List<PredictionDto> getFuturePredictions() {
        List<PredictionEntity> futurePreds = predictionRepository.findAllFuture();
        ArrayList<PredictionDto> toReturn = new ArrayList<>();
        for (PredictionEntity pEnt: futurePreds) {
            PredictionDto pDto = new PredictionDto();
            BeanUtils.copyProperties(pEnt, pDto);
            toReturn.add(pDto);
        }
        return toReturn;
    }
}
