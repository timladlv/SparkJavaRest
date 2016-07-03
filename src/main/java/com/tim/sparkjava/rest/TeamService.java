package com.tim.sparkjava.rest;

import java.util.List;

/**
 * Created by tim on 03/07/16.
 */
public interface TeamService {

    List<Team> getTeams();
    Team getTeam(int teamId);
}
