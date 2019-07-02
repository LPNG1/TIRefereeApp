package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cargo);
    }

    public void addBarrel(View view) {
        ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
        Toast.makeText(AddCargoActivity.this, "Barrel added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addAllianceCargo(View view) {
        ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
        Toast.makeText(AddCargoActivity.this, "Alliance Cargo added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addBox(View view) {
        ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
        Toast.makeText(AddCargoActivity.this, "Box added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addCrate(View view) {
        ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
        Toast.makeText(AddCargoActivity.this, "Crate added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addTreasure(View view) {
        ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
        Toast.makeText(AddCargoActivity.this, "Treasure added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
