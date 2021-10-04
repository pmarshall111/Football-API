package com.football.betting.api.datasource.repository;

import com.football.betting.api.datasource.entity.BetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, Integer> {

}
