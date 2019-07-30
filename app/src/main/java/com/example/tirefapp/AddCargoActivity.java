package com.example.tirefapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cargo);
    }

    public void addBarrel(View view) {
        Scorer.getInstance().addCargo("barrel");
        Toast.makeText(AddCargoActivity.this, "Barrel added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addAllianceCargo(View view) {
        Scorer.getInstance().addCargo("alliance-cargo");
        Toast.makeText(AddCargoActivity.this, "Alliance Cargo added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addBox(View view) {
        Scorer.getInstance().addCargo("box");
        Toast.makeText(AddCargoActivity.this, "Box added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addCrate(View view) {
        Scorer.getInstance().addCargo("crate");
        Toast.makeText(AddCargoActivity.this, "Crate added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addTreasure(View view) {
        Scorer.getInstance().addCargo("treasure");
        Toast.makeText(AddCargoActivity.this, "Treasure added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
