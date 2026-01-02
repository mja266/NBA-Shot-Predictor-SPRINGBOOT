package com.nba.api;

import com.nba.model.Shot;
import com.nba.service.MetadataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
@CrossOrigin
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping("/teams")
    public List<String> getTeams() {
        return metadataService.getTeams();
    }

    @GetMapping("/players")
    public List<String> getPlayers(@RequestParam String team) {
        return metadataService.getPlayers(team);
    }

    @GetMapping("/shots")
    public List<Shot> getShots(
            @RequestParam String team,
            @RequestParam String player
    ) {
        return metadataService.getShots(team, player);
    }
}
