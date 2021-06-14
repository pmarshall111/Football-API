package com.football.betting.api.datasource.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="team")
public class TeamEntity implements Serializable {
    @Id
    private int _id;

    @Column(columnDefinition = "text")
    private String name;

    @ManyToOne
    @JoinColumn(name="league_id")
    private LeagueEntity league;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeagueEntity getLeague() {
        return league;
    }

    public void setLeague(LeagueEntity league) {
        this.league = league;
    }
}
