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

    public static void main( String[] args ) {
        final InMemoryDao<Team> dao = new InMemoryDao<>();
        dao.put(new Team("teamName0", "managerName0"));
        dao.put(new Team("teamName1", "managerName1"));
        dao.put(new Team("teamName2", "managerName2"));
        final App app = new App(new TeamServiceImpl(dao));
        app.run();
    }

    public void run() {
        get("/teams", (request, response) -> {
            return teamService.getTeams();
        }, new JsonTransformer());
        get("/teams/:id", (request, response) -> {
            return teamService.getTeam(Integer.parseInt(request.params(":id")));
        }, new JsonTransformer());
    }
}
