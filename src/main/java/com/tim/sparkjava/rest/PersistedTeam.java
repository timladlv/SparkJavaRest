package com.tim.sparkjava.rest;

/**
 * Created by tim on 03/07/16.
 */
public class PersistedTeam {
    final int id;
    final Team team;

    public PersistedTeam(final int id, final Team team) {
        this.id = id;
        this.team = team;
    }
}