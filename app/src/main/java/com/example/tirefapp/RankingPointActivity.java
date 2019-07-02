package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RankingPointActivity extends AppCompatActivity {

    Button autoRpButton = findViewById(R.id.autoRP);
    Button cannonRpButton = findViewById(R.id.cannonRP);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_point);
    }

    public void addAutoRP(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that the alliance got the Autonomous Ranking Point");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RankingPointActivity.this, "Autonomous RP awarded!", Toast.LENGTH_SHORT).show();
                autoRpButton.setVisibility(View.GONE);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

    public void addCannonRP(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that the alliance got the Cannon Ranking Point");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RankingPointActivity.this, "Cannon RP awarded!", Toast.LENGTH_SHORT).show();
                cannonRpButton.setVisibility(View.GONE);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

}
