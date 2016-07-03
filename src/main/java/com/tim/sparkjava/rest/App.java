package com.tim.sparkjava.rest;

import static spark.Spark.get;

/**
 * Hello world!
 *
 */
public class App 
{
    private final TeamService teamService;

    public App(TeamService teamService) {
        this.teamService = teamService;
    }

    public static void main( String[] args )
    {
        final App app = new App(new TeamServiceImpl(new InMemoryDao<Team>()));
        app.run();
    }

    public void run() {
        get("/teams", (request, response) -> {
            teamService.getTeams();
            return "teams";
        });
        get("/teams/:id", (request, response) -> {
            teamService.getTeam(Integer.parseInt(request.params(":id")));
            return "team-i";
        });
    }
}
