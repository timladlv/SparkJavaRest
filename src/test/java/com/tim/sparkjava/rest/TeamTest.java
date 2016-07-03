package com.tim.sparkjava.rest;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by tim on 03/07/16.
 */
public class TeamTest {

    @Test
    public void testInstantiation() {
        Team team = new Team(1, "teamName", "managerName");
        assertNotNull(team);
    }
}