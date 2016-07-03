package com.tim.sparkjava.rest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tim on 03/07/16.
 */
public class TeamServiceTest {

    private TeamService uut;
    private Dao<Team> dao;

    @Before
    public void setup () {
        dao = mock(Dao.class);
        uut = new TeamServiceImpl(dao);
    }

    @Test
    public void testGet() {
        final Team expectedTeam = new Team(1, "teamName", "managerName");
        when(dao.get(1)).thenReturn(expectedTeam);

        final Team team = uut.getTeam(1);

        assertThat(team, is(expectedTeam));
    }

    @Test
    public void testGetAll() {
        final List<Team> expectedTeams = Arrays.asList(new Team(1, "teamName", "managerName"), new Team(2, "teamName2", "managerName2"));
        when(dao.get()).thenReturn(expectedTeams);

        final List<Team> teams = uut.getTeams();

        assertThat(teams, is(expectedTeams));

    }
}
