package com.nba.service;

import com.nba.model.Shot;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CsvShotDataService {

    private final List<Shot> shots = new ArrayList<>();

    @PostConstruct
    public void loadCsv() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new ClassPathResource("data/season_2024_25_shots.csv").getInputStream()
                    )
            );

            // Skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 5) continue;

                String team = parts[0].trim();
                String player = parts[1].trim();
                double x = Double.parseDouble(parts[2]);
                double y = Double.parseDouble(parts[3]);
                boolean made = parts[4].trim().equals("1");

                Shot shot = new Shot();
                shot.setTeam(team);
                shot.setPlayer(player);
                shot.setX(x);
                shot.setY(y);
                shot.setMade(made);

                shots.add(shot);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load CSV", e);
        }
    }

    public List<String> getTeams() {
        return shots.stream()
                .map(Shot::getTeam)
                .distinct()
                .sorted()
                .toList();
    }

    public List<String> getPlayersForTeam(String team, int limit) {
        return shots.stream()
                .filter(s -> s.getTeam().equals(team))
                .collect(Collectors.groupingBy(Shot::getPlayer, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Shot> getShots(String team, String player) {
        return shots.stream()
                .filter(s -> s.getTeam().equals(team))
                .filter(s -> s.getPlayer().equals(player))
                .toList();
    }
}
