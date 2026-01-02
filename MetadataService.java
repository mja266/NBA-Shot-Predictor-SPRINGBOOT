package com.nba.service;

import com.nba.model.Shot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {

    private final CsvShotDataService csv;

    public MetadataService(CsvShotDataService csv) {
        this.csv = csv;
    }

    public List<String> getTeams() {
        return csv.getTeams();
    }

    public List<String> getPlayers(String team) {
        return csv.getPlayersForTeam(team, 20);
    }

    public List<Shot> getShots(String team, String player) {
        return csv.getShots(team, player);
    }
}
