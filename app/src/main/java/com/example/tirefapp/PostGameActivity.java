package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostGameActivity extends AppCompatActivity {

    private static PostGameActivity instance;

    private JSONArray stacks = new JSONArray();
    private JSONObject object = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game);
        PostGameActivity.init();
    }

    public static void init() {
        if (instance == null)
            instance = new PostGameActivity();
    }

    public static PostGameActivity getInstance() {
        return instance;
    }

    public void createStack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainStackerActivity.class);
        startActivity(intent);
    }

    public void deleteStack(View view) {
        Intent intent = new Intent(getApplicationContext(), DeleteStackActivity.class);
        startActivity(intent);
    }

    public void endPostGame(View view) {
        try {
            object.put("stack", stacks);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ServerWriter.getInstance().sendMessage("stack", object);
        ServerWriter.getInstance().interrupt();
        ServerReader.getInstance().interrupt();
        finish();
    }

    public void addStack(JSONObject stack) {
        stacks.put(stack);
    }

    public int stackCount() {
        return stacks.length();
    }

    public JSONArray getStacks() {
        return stacks;
    }

    public void removeStack(int index) {
        stacks.remove(index);
    }

}
