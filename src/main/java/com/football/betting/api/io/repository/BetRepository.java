package com.football.betting.api.io.repository;

import com.football.betting.api.io.entity.BetEntity;
import dbTables.BetTable;
import dbTables.MatchTable;
import dbTables.TeamTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, Integer> {
    //Order of Selects is important for use in BetServiceImpl
    @Query(value="SELECT " + BetTable.TABLE_NAME + "." + BetTable.COL_RESULT_BET_ON + ", " +
            BetTable.TABLE_NAME + "." + BetTable.COL_ODDS + ", " +
            BetTable.TABLE_NAME + "." + BetTable.COL_STAKE + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_HOME_WIN_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_DRAW_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_AWAY_WIN_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_DATE + ", " +
            "homeTeam." + TeamTable.COL_TEAM_NAME + " AS homeTeamName, " +
            "awayTeam." + TeamTable.COL_TEAM_NAME + " AS awayTeamName " +
            " FROM " + BetTable.TABLE_NAME +
            " INNER JOIN " + MatchTable.TABLE_NAME + " ON " + BetTable.COL_MATCH_ID + " = " + MatchTable.TABLE_NAME + "._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS homeTeam ON " + MatchTable.COL_HOMETEAM_ID + " = homeTeam._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS awayTeam ON " + MatchTable.COL_AWAYTEAM_ID + " = awayTeam._id" +
            " WHERE " + MatchTable.COL_DATE + " < :date", nativeQuery = true)
    List<Object[]> findAllHistoric(@Param("date") String latestDate);

    @Query(value="SELECT " + BetTable.TABLE_NAME + "." + BetTable.COL_RESULT_BET_ON + ", " +
            BetTable.TABLE_NAME + "." + BetTable.COL_ODDS + ", " +
            BetTable.TABLE_NAME + "." + BetTable.COL_STAKE + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_HOME_WIN_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_DRAW_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_AWAY_WIN_ODDS + ", " +
            MatchTable.TABLE_NAME + "." + MatchTable.COL_DATE + ", " +
            "homeTeam." + TeamTable.COL_TEAM_NAME + " AS homeTeamName, " +
            "awayTeam." + TeamTable.COL_TEAM_NAME + " AS awayTeamName " +
            " FROM " + BetTable.TABLE_NAME +
            " INNER JOIN " + MatchTable.TABLE_NAME + " ON " + BetTable.COL_MATCH_ID + " = " + MatchTable.TABLE_NAME + "._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS homeTeam ON " + MatchTable.COL_HOMETEAM_ID + " = homeTeam._id" +
            " INNER JOIN " + TeamTable.TABLE_NAME + " AS awayTeam ON " + MatchTable.COL_AWAYTEAM_ID + " = awayTeam._id" +
            " WHERE " + MatchTable.COL_DATE + " > :date", nativeQuery = true)
    List<Object[]> findAllFuture(@Param("date") String earliestDate);
}
