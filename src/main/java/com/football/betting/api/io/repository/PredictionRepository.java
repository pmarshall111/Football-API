package com.football.betting.api.io.repository;

import com.football.betting.api.io.entity.PredictionEntity;
import dbTables.MatchTable;
import dbTables.PredictionTable;
import dbTables.TeamTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends CrudRepository<PredictionEntity, Integer> {
    //Order of selects is important for ordering of fields in PredictionServiceImpl
    @Query(value="SELECT " + PredictionTable.TABLE_NAME + "." + PredictionTable.COL_HOME_PRED + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_DRAW_PRED + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_AWAY_PRED + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_H_ODDS + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_D_ODDS + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_A_ODDS + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_BOOKIE_NAME + ", " +
            PredictionTable.TABLE_NAME + "." + PredictionTable.COL_WITH_LINEUPS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_DATE + ", " +
            "homeTeam." + TeamTable.COL_TEAM_NAME + " AS homeTeamName, " +
            "awayTeam." + TeamTable.COL_TEAM_NAME + " AS awayTeamName " +
            " FROM " + PredictionTable.TABLE_NAME +
            " INNER JOIN " + MatchTable.TABLE_NAME + " ON " + PredictionTable.COL_MATCH_ID + " = " + MatchTable.TABLE_NAME + "._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS homeTeam ON " + MatchTable.COL_HOMETEAM_ID + " = homeTeam._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS awayTeam ON " + MatchTable.COL_AWAYTEAM_ID + " = awayTeam._id" +
            " WHERE " + MatchTable.TABLE_NAME + "." + MatchTable.COL_DATE + " > ':date'", nativeQuery = true)
    List<Object[]> findAllFuture(@Param("date") String earliestDate);
}
