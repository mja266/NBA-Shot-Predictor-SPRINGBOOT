package com.nba.service;

import com.nba.inference.OnnxModelService;
import com.nba.model.PredictionRequest;
import com.nba.model.PredictionResponse;
import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    private final OnnxModelService onnx;

    public PredictionService(OnnxModelService onnx) {
        this.onnx = onnx;
    }

    public PredictionResponse predict(PredictionRequest req) {
        double probability = onnx.predictProbability(req.getX(), req.getY());
        boolean made = probability > 0.5;
        return new PredictionResponse(probability, made);
    }
}
