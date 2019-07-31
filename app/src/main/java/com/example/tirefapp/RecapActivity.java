package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.MessageFormat;

public class RecapActivity extends AppCompatActivity {

    private TextView recapText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        recapText = findViewById(R.id.gameRecap);

        recapText.setText(MessageFormat.format("You were in charge of robot {0}.\n" +
                                                "Your robot scored {1} points during the game.\n" +
                                                "Your alliance stacked stacks worth {2} points.\n" +
                                                "Your robot preformed {3} points of penalties\n" +
                                                "that will be awarded to the opposing alliance.\n" +
                                                "Your alliance earned {4} RPs.\n" +
                                                "Show this to the head referee and confirm.",
                                                OpeningActivity.getId(),
                                                Scorer.getInstance().getMatchPoints(),
                                                Scorer.getInstance().getStackPoints(),
                                                Scorer.getInstance().getPenaltyPoints(),
                                                Scorer.getInstance().getRp()));
    }


    public void endGame(View view) {
        finish();
    }
}
