package com.nba.controller;

import com.nba.model.PredictionRequest;
import com.nba.model.PredictionResponse;
import com.nba.service.MetadataService;
import com.nba.service.PredictionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final MetadataService metadata;
    private final PredictionService predictor;

    public ApiController(MetadataService metadata, PredictionService predictor) {
        this.metadata = metadata;
        this.predictor = predictor;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/teams")
    public List<String> teams() {
        return metadata.getTeams();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/players")
    public List<String> players(@RequestParam("team") String team) {
        return metadata.getPlayers(team);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/predict")
    public PredictionResponse predict(@Valid @RequestBody PredictionRequest req) {
        return predictor.predict(req);
    }
}
