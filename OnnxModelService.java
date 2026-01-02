package com.nba.inference;

import org.springframework.stereotype.Service;

/**
 * Stubbed ONNX service.
 * This keeps the architecture intact without requiring ONNX Runtime.
 * Replace implementation later when ONNX is wired.
 */
@Service
public class OnnxModelService {

    public double predictProbability(double x, double y) {
        // Placeholder logic (distance-based probability)
        double distance = Math.sqrt(x * x + y * y);
        return Math.max(0.05, Math.min(0.95, 1.0 - (distance / 30.0)));
    }
}
