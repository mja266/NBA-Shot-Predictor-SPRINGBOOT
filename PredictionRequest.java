package com.nba.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PredictionRequest {
    @NotBlank
    private String team;

    @NotBlank
    private String player;

    @NotNull
    private Integer period; // 1-4

    @NotBlank
    private String pctimestring; // "MM:SS"

    @NotBlank
    private String shot_type; // e.g. "2PT Field Goal"

    @NotNull
    private Double x;

    @NotNull
    private Double y;

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public String getPlayer() { return player; }
    public void setPlayer(String player) { this.player = player; }

    public Integer getPeriod() { return period; }
    public void setPeriod(Integer period) { this.period = period; }

    public String getPctimestring() { return pctimestring; }
    public void setPctimestring(String pctimestring) { this.pctimestring = pctimestring; }

    public String getShot_type() { return shot_type; }
    public void setShot_type(String shot_type) { this.shot_type = shot_type; }

    public Double getX() { return x; }
    public void setX(Double x) { this.x = x; }

    public Double getY() { return y; }
    public void setY(Double y) { this.y = y; }
}
