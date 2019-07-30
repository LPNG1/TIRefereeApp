package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PostGameActivity extends AppCompatActivity {

    private static PostGameActivity instance;

    private ArrayList<ArrayList<String>> stacks = new ArrayList<>();

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
        finish();
    }

    public void addStack(ArrayList stack) {
        stacks.add(stack);
    }

    public int stackCount() {
        return stacks.size();
    }

    public ArrayList<ArrayList<String>> getStacks() {
        return stacks;
    }

    public void removeStack(int index) {
        stacks.remove(index);
    }

}
