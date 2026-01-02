package com.nba.model;

public class PredictionResponse {

    private double probability;
    private boolean made;

    // Required by Spring / Jackson
    public PredictionResponse() {
    }

    // ✅ FIX: constructor that PredictionService is calling
    public PredictionResponse(double probability, boolean made) {
        this.probability = probability;
        this.made = made;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public boolean isMade() {
        return made;
    }

    public void setMade(boolean made) {
        this.made = made;
    }
}
