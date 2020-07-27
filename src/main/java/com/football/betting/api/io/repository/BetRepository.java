package com.football.betting.api.io.repository;

import com.football.betting.api.io.entity.BetEntity;
import dbTables.BetTable;
import dbTables.MatchTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, Integer> {
    @Query(value="SELECT * FROM " + BetTable.TABLE_NAME +
            " INNER JOIN " + MatchTable.TABLE_NAME + " ON " + BetTable.COL_MATCH_ID + " = " + MatchTable.TABLE_NAME + "._id" +
            " WHERE " + MatchTable.COL_DATE + " < ':date'", nativeQuery = true)
    List<BetEntity> findAllHistoric(@Param("date") String latestDate);

    @Query(value="SELECT * FROM " + BetTable.TABLE_NAME +
            " INNER JOIN " + MatchTable.TABLE_NAME + " ON " + BetTable.COL_MATCH_ID + " = " + MatchTable.TABLE_NAME + "._id" +
            " WHERE " + MatchTable.COL_DATE + " > ':date'", nativeQuery = true)
    List<BetEntity> findAllFuture(@Param("date") String earliestDate);
}
