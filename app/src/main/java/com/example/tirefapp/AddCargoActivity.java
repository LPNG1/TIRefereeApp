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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Barrel was added");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(AddCargoActivity.this, "Barrel added!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void addAllianceCargo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that an Alliance Cargo was added");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(AddCargoActivity.this, "Alliance Cargo added!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void addBox(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Box was added");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(AddCargoActivity.this, "Box added!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void addCrate(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Crate was added");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(AddCargoActivity.this, "Crate added!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void addTreasure(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Treasure was added");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(AddCargoActivity.this, "Treasure added!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

}
