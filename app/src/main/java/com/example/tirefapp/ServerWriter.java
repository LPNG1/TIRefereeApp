package com.example.tirefapp;

public class ServerWriter extends Thread {

    private static ServerWriter instance;

    public static void init() {
        if (instance == null)
            instance = new ServerWriter();
    }

    public static ServerWriter getInstance() {
        return instance;
    }

    public void sendMessage() {
        //TODO: Implement sending with JSON
    }

}
