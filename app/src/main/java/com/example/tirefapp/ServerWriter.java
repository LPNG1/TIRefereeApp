package com.example.tirefapp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServerWriter extends Thread {

    private static ServerWriter instance;

    private Socket socket;
    private PrintStream printStream;

    @Override
    public void run() {
        try {
            socket = new Socket("10.0.0.4", 2630);
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
