package com.nba.api;

import com.nba.model.PredictionRequest;
import com.nba.model.PredictionResponse;
import com.nba.service.PredictionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @PostMapping("/predict")
    public PredictionResponse predict(@RequestBody PredictionRequest req) {
        return service.predict(req);
    }
}
