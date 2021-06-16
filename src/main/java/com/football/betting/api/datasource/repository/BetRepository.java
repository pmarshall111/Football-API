package com.football.betting.api.datasource.repository;

import com.football.betting.api.datasource.entity.BetEntity;
import dbTables.BetTable;
import dbTables.MatchTable;
import dbTables.PredictionTable;
import dbTables.TeamTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, Integer> {

}
