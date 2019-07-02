package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView gameTime, anchorText, gameStateText, refId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameTime = findViewById(R.id.gameTime);
        anchorText = findViewById(R.id.anchors);
        gameStateText = findViewById(R.id.gameState);
        refId = findViewById(R.id.refId);
    }

    @SuppressLint("SetTextI18n")
    public void updateText() {
        while (ServerReader.getInstance().secondsPassed() <= 210) {
            gameTime.setText("Game Time: " + ServerReader.getInstance().getMinutes() +
                            ":" + ServerReader.getInstance().getSeconds());
            System.out.println(gameTime.getText());
            anchorText.setText("Anchors: " + ServerReader.getInstance().anchorsRaised() + "/2");
            System.out.println(anchorText.getText());
            gameStateText.setText(ServerReader.getInstance().getGameState());
            System.out.println(gameStateText.getText());
            refId.setText("Referee: " + OpeningActivity.getId());
            System.out.println(refId.getText());
        }
    }

    public void addCargoPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), AddCargoActivity.class);
        startActivity(intent);
    }

    public void removeCargoPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), RemoveCargoActivity.class);
        startActivity(intent);
    }

    public void cannonPressed(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that the cannon was shot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(GameActivity.this, "Cannon shot!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

    public void rpPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), RankingPointActivity.class);
        startActivity(intent);
    }

    public void penaltiesPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), PenaltyActivity.class);
        startActivity(intent);
    }

    public void robotStatePressed(View view) {

    }
}
