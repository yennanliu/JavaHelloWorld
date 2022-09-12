package dev.bean;

// https://dzone.com/articles/how-to-convert-csv-to-json-in-java

public class Player {

    private int year;
    private String teamId;
    private String leagueId;
    private String playerId;
    private int salary;

    public Player(int year, String teamId, String leagueId, String playerId, int salary) {
        this.year = year;
        this.teamId = teamId;
        this.leagueId = leagueId;
        this.playerId = playerId;
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
