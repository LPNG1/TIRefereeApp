package com.example.tirefapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;
import android.os.Handler;

public class GameActivity extends AppCompatActivity {

    private TextView gameTime, refId;
    private int secondsPassed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Scorer.init();

        gameTime = findViewById(R.id.gameTime);
        System.out.println(gameTime);
        refId = findViewById(R.id.refId);

        refId.setText(MessageFormat.format("Referee: {0}", OpeningActivity.getId()));

        final Handler uiHandler = new Handler();
        new Runnable() {
            @Override
            public void run() {
                System.out.println("time:" + secondsPassed);
                System.out.println("points:" + Scorer.getInstance().getPoints());
                System.out.println("rps:" + Scorer.getInstance().getRp());
                System.out.println("penalty:" + Scorer.getInstance().getPenaltyPoints());
                setGameTimeText(secondsPassed / 60, secondsPassed % 60);
                secondsPassed++;
                if(secondsPassed <= 210)
                    uiHandler.postDelayed(this, 1000);
            }
        }.run();

        Handler endHandler = new Handler();
        endHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPostGame();
            }
        }, 210000);
    }
    
    public void addCargoPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), AddCargoActivity.class);
        startActivity(intent);
    }

    public void removeCargoPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), RemoveCargoActivity.class);
        startActivity(intent);
    }

    public void rpPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), RankingPointActivity.class);
        startActivity(intent);
    }

    public void penaltiesPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), PenaltyActivity.class);
        startActivity(intent);
    }

    public void setGameTimeText(int minutes, int seconds) {
        gameTime.setText(MessageFormat.format("Game Time: {0}:{1}", minutes, seconds));
    }

    public void startPostGame() {
        Intent intent = new Intent(getApplicationContext(), PostGameActivity.class);
        startActivity(intent);
        finish();
    }
}
