package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainStackerActivity extends AppCompatActivity {

    private TextView stackDisplay;

    private ArrayList<String> stack = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stacker);
        stackDisplay = findViewById(R.id.stackDisplay);
    }

    public void stackBarrel(View view) {
        stackCargo("barrel");
        Toast.makeText(MainStackerActivity.this, "Barrel stacked!", Toast.LENGTH_SHORT).show();
    }

    public void stackAllianceCargo(View view) {
        stackCargo("alliance-cargo");
        Toast.makeText(MainStackerActivity.this, "Alliance Cargo stacked!", Toast.LENGTH_SHORT).show();
    }

    public void stackBox(View view) {
        stackCargo("box");
        Toast.makeText(MainStackerActivity.this, "Box stacked!", Toast.LENGTH_SHORT).show();
    }

    public void stackCrate(View view) {
        stackCargo("crate");
        Toast.makeText(MainStackerActivity.this, "Crate stacked!", Toast.LENGTH_SHORT).show();
    }

    public void stackTreasure(View view) {
        stackCargo("treasure");
        Toast.makeText(MainStackerActivity.this, "Treasure stacked!", Toast.LENGTH_SHORT).show();
        PostGameActivity.getInstance().addStack(stack);
        finish();
    }

    public void stackCargo(String cargoType) {
        stack.add(cargoType);
        stackDisplay.append(cargoType + "\n");
    }

    public void stopStack(View view) {
        PostGameActivity.getInstance().addStack(stack);
        finish();
    }
}
