package com.tim.sparkjava.rest;

import java.util.List;

/**
 * Created by tim on 03/07/16.
 */
public class TeamServiceImpl implements TeamService {

    private final Dao<Team> dao;

    public TeamServiceImpl(Dao<Team> dao) {
        this.dao = dao;
    }

    @Override
    public List<Team> getTeams() {
        return dao.get();
    }

    @Override
    public Team getTeam(int teamId) {
        return dao.get(teamId);
    }
}
