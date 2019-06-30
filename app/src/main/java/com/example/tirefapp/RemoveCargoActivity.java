package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RemoveCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_cargo);
    }

    public void removeCargo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Barrel was removed");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RemoveCargoActivity.this, "Barrel removed!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void removeAllianceCargo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that an Alliance Cargo was removed");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RemoveCargoActivity.this, "Alliance Cargo removed!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void removeBox(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Box was removed");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RemoveCargoActivity.this, "Box removed!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void removeCrate(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Crate was removed");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RemoveCargoActivity.this, "Crate removed!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

    public void removeTreasure(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that a Treasure was removed");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage(); //TODO: Change to use JSON
                Toast.makeText(RemoveCargoActivity.this, "Treasure removed!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        this.finish();
    }

}
