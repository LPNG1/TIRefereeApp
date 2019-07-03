package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PostGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game);
    }

    public void createStack(View view) {
        Intent intent = new Intent(getApplicationContext(), StackBaseActivity.class);
        startActivity(intent);
    }

    public void deleteStack(View view) {
        Intent intent = new Intent(getApplicationContext(), DeleteStackActivity.class);
        startActivity(intent);
    }

    public void endPostGame(View view) {
        ServerWriter.getInstance().sendMessage();
        ServerWriter.getInstance().close();
        ServerReader.getInstance().close();
        finish();
    }

}
