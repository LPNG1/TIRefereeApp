package com.example.tirefapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServerWriter extends Thread {

    private static ServerWriter instance;

    private Socket socket;
    private PrintStream printStream;

    private JSONArray array;
    private JSONObject refId = new JSONObject(),
                       event;

    @Override
    public void run() {
        try {
            socket = new Socket("10.0.0.4", 2630);
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            refId.put("team", OpeningActivity.getRefTeam());
            refId.put("id", OpeningActivity.getRefNumber());
        } catch (JSONException e) {
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

    public void sendMessage(String eventId, JSONObject eventData) {
        event = new JSONObject();
        array = new JSONArray();

        try {
            event.put("event-id", eventId);
            event.put("event-data", eventData);

            array.put(refId);
            array.put(event);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        printStream.println(array);
    }

}
