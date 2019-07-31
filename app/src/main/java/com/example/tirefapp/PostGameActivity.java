package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class PostGameActivity extends AppCompatActivity {

    private static PostGameActivity instance;

    private static ArrayList<ArrayList<String>> stacks = new ArrayList<>();

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
        for (ArrayList<String> stack : stacks) {
            Scorer.getInstance().addStack(stack);
        }
        Intent intent = new Intent(getApplicationContext(), RecapActivity.class);
        startActivity(intent);
        finish();
    }

    public void addStack(ArrayList<String> stack) {
        stacks.add(stack);
    }

    public ArrayList<ArrayList<String>> getStacks() {
        return stacks;
    }

    public void removeStack(int index) {
        stacks.remove(index);
    }

}
