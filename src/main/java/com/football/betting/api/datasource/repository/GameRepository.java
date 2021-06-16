package com.football.betting.api.datasource.repository;

import com.football.betting.api.datasource.entity.GameEntity;
import com.football.betting.api.datasource.entity.PredictionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Integer> {
    List<GameEntity> findAllByDateGreaterThanAndDateLessThan(String greaterThan, String lessThan);
}
