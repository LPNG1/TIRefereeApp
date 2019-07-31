package com.example.tirefapp;

import java.util.ArrayList;

public class Scorer {

    private static Scorer instance;

    private int matchPoints = 0;
    private int stackPoints = 0;
    private int rp = 0;
    private int penaltyPoints = 0;

    static void init() {
        if (instance == null)
            instance = new Scorer();
    }

    static Scorer getInstance() {
        return instance;
    }

    public void addCargo(String cargoType) {
        switch (cargoType) {
            case "barrel":
                matchPoints += 6;
                break;
            case "alliance-cargo":
                matchPoints += 4;
                break;
            case "box":
                matchPoints += 8;
                break;
            case "crate":
                matchPoints += 10;
                break;
            case "treasure":
                matchPoints += 20;
                break;
        }
    }

    public void removeCargo(String cargoType) {
        switch (cargoType) {
            case "barrel":
                matchPoints -= 6;
                break;
            case "alliance-cargo":
                matchPoints -= 4;
                break;
            case "box":
                matchPoints -= 8;
                break;
            case "crate":
                matchPoints -= 10;
                break;
            case "treasure":
                matchPoints -= 20;
                break;
        }
    }

    public void addRankingPoint() {
        rp++;
    }

    public void penalize(String penaltyType) {
        switch (penaltyType) {
            case "penalty":
                penaltyPoints += 5;
                break;
            case "foul":
                penaltyPoints += 20;
                break;
        }
    }

    public void addStack(ArrayList<String> stack) {
        int stackValue = 0;
        double stackMultiplier = 1.0;

        loop: for (int i = 0; i <= stack.size()-1; i++) {
            switch (stack.get(i)) {
                case "barrel":
                    stackValue += 6;
                    if (i != 0)
                        stackMultiplier *= 1.4;
                    break;
                case "alliance-cargo":
                    stackValue += 4;
                    if (i != 0)
                        stackMultiplier *= 1.6;
                    break;
                case "box":
                    stackValue += 8;
                    if (i != 0)
                        stackMultiplier *= 1.8;
                    break;
                case "crate":
                    stackValue += 10;
                    if (i != 0)
                        stackMultiplier *= 2.0;
                    break;
                case "treasure":
                    stackMultiplier += 1.5;
                    stackValue *= stackMultiplier;
                    stackValue += 20;
                    stackPoints += stackValue;
                    break loop;
            }
        }
        stackValue *= stackMultiplier;
        stackPoints += stackValue;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getStackPoints() {
        return stackPoints;
    }

    public int getRp() {
        return rp;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }
}
