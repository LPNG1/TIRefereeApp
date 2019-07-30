package com.example.tirefapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PenaltyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty);
    }

    public void givePenalty(View view) {
        Scorer.getInstance().penalize("penalty");
        Toast.makeText(PenaltyActivity.this, "Penalty given!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void giveFoul(View view) {
        Scorer.getInstance().penalize("foul");
        Toast.makeText(PenaltyActivity.this, "Foul given!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
