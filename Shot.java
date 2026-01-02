package com.nba.model;

public class Shot {

    private String team;
    private String player;
    private int quarter;
    private double timeLeft;
    private double x;
    private double y;
    private boolean made;

    public String getTeam() { return team; }
    public String getPlayer() { return player; }
    public int getQuarter() { return quarter; }
    public double getTimeLeft() { return timeLeft; }
    public double getX() { return x; }
    public double getY() { return y; }
    public boolean isMade() { return made; }

    public void setTeam(String team) { this.team = team; }
    public void setPlayer(String player) { this.player = player; }
    public void setQuarter(int quarter) { this.quarter = quarter; }
    public void setTimeLeft(double timeLeft) { this.timeLeft = timeLeft; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setMade(boolean made) { this.made = made; }
}
