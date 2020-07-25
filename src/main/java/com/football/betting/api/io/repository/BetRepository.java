package com.football.betting.api.io.repository;

import com.football.betting.api.io.entity.BetEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository {
    @Query(value="", countQuery="", nativeQuery = true)
    List<BetEntity> findAllHistoric();

    @Query(value="", countQuery="", nativeQuery = true)
    List<BetEntity> findAllFuture();
}
