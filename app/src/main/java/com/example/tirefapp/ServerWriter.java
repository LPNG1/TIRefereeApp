package com.example.tirefapp;

import android.util.JsonWriter;

import java.io.IOException;

public class ServerWriter extends Thread {

    private static ServerWriter instance;

    private JsonWriter writer;

    @Override
    public void run() {
        super.run();
    }

    public static void init() {
        if (instance == null)
            instance = new ServerWriter();
    }

    public static ServerWriter getInstance() {
        return instance;
    }

    public void sendMessage() {

    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
