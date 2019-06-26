package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView gameTime, anchorText, gameStateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameTime =  findViewById(R.id.gameTime);
        anchorText = findViewById(R.id.anchors);
        gameStateText = findViewById(R.id.gameState);
        run();
    }

    public void run() {
        while (ServerReader.getInstance().secondsPassed() <= 210) {
            gameTime.setText("Game Time: " + ServerReader.getInstance().getMinutes() +
                            ":" + ServerReader.getInstance().getSeconds());
            anchorText.setText("Anchors: " + ServerReader.getInstance().anchorsRaised() + "/2");
            gameStateText.setText(ServerReader.getInstance().getGameState());
        }
    }

    public void addCargo() {
    }
}
