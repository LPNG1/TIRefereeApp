package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class RemoveCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_cargo);
    }

    public void removeCargo(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "barrel");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("del-cargo", object);
        Toast.makeText(RemoveCargoActivity.this, "Barrel removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeAllianceCargo(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "alliance-cargo");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("del-cargo", object);
        Toast.makeText(RemoveCargoActivity.this, "Alliance Cargo removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeBox(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "box");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("del-cargo", object);
        Toast.makeText(RemoveCargoActivity.this, "Box removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeCrate(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "crate");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("del-cargo", object);
        Toast.makeText(RemoveCargoActivity.this, "Crate removed!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void removeTreasure(View view) {
        JSONObject object = new JSONObject();

        try {
            object.put("cargo-id", "treasure");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ServerWriter.getInstance().sendMessage("del-cargo", object);
        Toast.makeText(RemoveCargoActivity.this, "Treasure removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
