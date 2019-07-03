package com.example.tirefapp;

import android.util.JsonReader;

import java.io.IOException;
import java.net.Socket;

public class ServerReader extends Thread {

    private static ServerReader instance;

    private JsonReader reader;

    private int anchors = 0;
    private int[] timeLeft = {2, 25}; //timeLeft[0] = Minutes, timeLeft[1] = Seconds
    private String gameState = "Autonomous";

    public static void init() {
        if (instance == null)
            instance = new ServerReader();
    }

    public static ServerReader getInstance() {
        return instance;
    }

    public int anchorsRaised() {
        return anchors;
    }

    public String getGameState() {
        return gameState;
    }

    public int[] getTimeLeft() {
        return timeLeft;
    }

    public int getMinutes() {
        return timeLeft[0];
    }

    public int getSeconds() {
        return timeLeft[1];
    }

    public int getSecondsPassed() {
        return timeLeft[0]*60 + timeLeft[1];
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
