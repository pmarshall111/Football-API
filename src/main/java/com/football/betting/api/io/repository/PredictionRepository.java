package com.football.betting.api.io.repository;

import com.football.betting.api.io.entity.BetEntity;
import com.football.betting.api.io.entity.PredictionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository {
    @Query(value="", countQuery="", nativeQuery = true)
    List<PredictionEntity> findAllFuture();
}
