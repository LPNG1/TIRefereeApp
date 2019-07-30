package com.example.tirefapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_cargo);
    }

    public void removeBarrel(View view) {
        Scorer.getInstance().removeCargo("barrel");
        Toast.makeText(RemoveCargoActivity.this, "Barrel removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeAllianceCargo(View view) {
        Scorer.getInstance().removeCargo("alliance-cargo");
        Toast.makeText(RemoveCargoActivity.this, "Alliance Cargo removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeBox(View view) {
        Scorer.getInstance().removeCargo("box");
        Toast.makeText(RemoveCargoActivity.this, "Box removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void removeCrate(View view) {
        Scorer.getInstance().removeCargo("crate");
        Toast.makeText(RemoveCargoActivity.this, "Crate removed!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void removeTreasure(View view) {
        Scorer.getInstance().removeCargo("treasure");
        Toast.makeText(RemoveCargoActivity.this, "Treasure removed!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
