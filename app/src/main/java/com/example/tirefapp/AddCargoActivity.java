package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class AddCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cargo);
    }

    public void addBarrel(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "barrel");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("add-cargo", object);
        Toast.makeText(AddCargoActivity.this, "Barrel added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addAllianceCargo(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "alliance-cargo");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("add-cargo", object);
        Toast.makeText(AddCargoActivity.this, "Alliance Cargo added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addBox(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "box");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("add-cargo", object);
        Toast.makeText(AddCargoActivity.this, "Box added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addCrate(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "crate");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("add-cargo", object);
        Toast.makeText(AddCargoActivity.this, "Crate added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addTreasure(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "treasure");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("add-cargo", object);
        Toast.makeText(AddCargoActivity.this, "Treasure added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
