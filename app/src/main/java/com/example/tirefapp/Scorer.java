package com.example.tirefapp;

import java.util.ArrayList;

public class Scorer {

    private static Scorer instance;

    private int points = 0;
    private int rp = 0;
    private int penaltyPoints = 0;

    static void init() {
        if (instance == null)
            instance = new Scorer();
    }

    static Scorer getInstance() {
        return instance;
    }

    void addCargo(String cargoType) {
        switch (cargoType) {
            case "barrel":
                points += 6;
                break;
            case "alliance-cargo":
                points += 4;
                break;
            case "box":
                points += 8;
                break;
            case "crate":
                points += 10;
                break;
            case "treasure":
                points += 20;
                break;
        }
    }

    void removeCargo(String cargoType) {
        switch (cargoType) {
            case "barrel":
                points -= 6;
                break;
            case "alliance-cargo":
                points -= 4;
                break;
            case "box":
                points -= 8;
                break;
            case "crate":
                points -= 10;
                break;
            case "treasure":
                points -= 20;
                break;
        }
    }

    void addRankingPoint() {
        rp++;
    }

    void penalize(String penaltyType) {
        switch (penaltyType) {
            case "penalty":
                penaltyPoints += 5;
                break;
            case "foul":
                penaltyPoints += 20;
                break;
        }
    }

    void addStack(ArrayList<ArrayList<String>> stacks) {

    }

    int getPoints() {
        return points;
    }

    int getRp() {
        return rp;
    }

    int getPenaltyPoints() {
        return penaltyPoints;
    }
}
