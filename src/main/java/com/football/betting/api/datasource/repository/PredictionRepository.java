package com.football.betting.api.datasource.repository;

import com.football.betting.api.datasource.entity.PredictionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends CrudRepository<PredictionEntity, Integer> {
}