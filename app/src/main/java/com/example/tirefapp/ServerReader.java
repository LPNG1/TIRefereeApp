package com.example.tirefapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerReader extends Thread {

    private static ServerReader instance;

    private Socket socket;
    private Scanner scanner;

    private int anchors = 0;
    private int gameTime = 0;
    private String gameState = "Autonomous";


    @Override
    public void run() {
        try {
            socket = new Socket("10.100.102.9", 5951);
            scanner = new Scanner(socket.getInputStream());

            while (!this.isInterrupted()) {
                if(scanner.hasNext()) {
                    try {
                        JSONObject gameData = new JSONObject(scanner.nextLine());
                        anchors = gameData.getInt("anchors");
                        gameTime = gameData.getInt("game-time");
                        gameState = gameData.getString("game-state");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public int getMinutes() {
        return (gameTime - getSeconds())/60;
    }

    public int getSeconds() {
        return gameTime%60;
    }

    public int getSecondsPassed() {
        return gameTime;
    }

}
