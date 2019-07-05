package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainStackerActivity extends AppCompatActivity {

    private JSONArray stack;

    private TextView stackDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stacker);
        stack = new JSONArray();
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
    }

    public void stackCargo(String cargoType) {
        JSONObject cargo = new JSONObject();
        try {
            cargo.put("id", stack.length());
            cargo.put("type", cargoType);
            stack.put(cargo);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        stackDisplay.append(cargoType + "\n");
    }

    public void stopStack(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("stack-id", PostGameActivity.getInstance().stackCount());
            object.put("cargo", stack);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PostGameActivity.getInstance().addStack(object);
        finish();
    }
}
