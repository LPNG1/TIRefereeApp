package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class PenaltyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty);
    }

    public void givePenalty(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("penalty-id", "penalty");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("penalty", object);
        Toast.makeText(PenaltyActivity.this, "Penalty given!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void giveFoul(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("penalty-id", "penalty");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("penalty", object);
        Toast.makeText(PenaltyActivity.this, "Foul given!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
