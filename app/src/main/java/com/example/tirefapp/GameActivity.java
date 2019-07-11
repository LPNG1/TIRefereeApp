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

import org.json.JSONException;
import org.json.JSONObject;

import java.text.MessageFormat;

public class GameActivity extends AppCompatActivity {

    private static GameActivity instance;

    private TextView gameTime, anchorText, gameStateText, refId;

    private int cannonsShot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ServerReader.init();
        ServerWriter.init();

        gameTime = findViewById(R.id.gameTime);
        anchorText = findViewById(R.id.anchors);
        gameStateText = findViewById(R.id.gameState);
        refId = findViewById(R.id.refId);

        refId.setText(MessageFormat.format("Referee: {0}", OpeningActivity.getId()));
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gameTime.setText(MessageFormat.format("Game Time: {0}:{1}", ServerReader.getInstance().getMinutes(), ServerReader.getInstance().getSeconds()));
                anchorText.setText(MessageFormat.format("Anchors: {0}/2", ServerReader.getInstance().anchorsRaised()));
                gameStateText.setText(ServerReader.getInstance().getGameState());
            }
        });

        ServerWriter.getInstance().start();
        ServerReader.getInstance().start();
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
        final JSONObject object = new JSONObject();
        cannonsShot++;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that the cannon was shot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                try {
                    object.put("cannon-id", cannonsShot);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ServerWriter.getInstance().sendMessage("cannon", object);
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
        Intent intent = new Intent(getApplicationContext(), DisableActivity.class);
        startActivity(intent);
    }

    public void startPostGame() {
        Intent intent = new Intent(getApplicationContext(), PostGameActivity.class);
        startActivity(intent);
        finish();
    }
}
