package com.example.tirefapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class DisableActivity extends AppCompatActivity {

    Button redRobot1, redRobot2, blueRobot1, blueRobot2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable);
        redRobot1 = findViewById(R.id.redRobot1);
        redRobot2 = findViewById(R.id.redRobot2);
        blueRobot1 = findViewById(R.id.blueRobot1);
        blueRobot2 = findViewById(R.id.blueRobot2);

        if(OpeningActivity.getId().startsWith("Red")) {
            blueRobot1.setVisibility(View.GONE);
            blueRobot2.setVisibility(View.GONE);
        }
        else {
            redRobot1.setVisibility(View.GONE);
            redRobot2.setVisibility(View.GONE);
        }
    }

    public void disableRed1(View view) {
        final JSONObject object = new JSONObject();

        try {
            object.put("robot-id", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that you would like to disable this robot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage("disable", object);
                Toast.makeText(DisableActivity.this, "Robot disabled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

    public void disableRed2(View view) {
        final JSONObject object = new JSONObject();

        try {
            object.put("robot-id", 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that you would like to disable this robot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage("disable", object);
                Toast.makeText(DisableActivity.this, "Robot disabled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

    public void disableBlue1(View view) {
        final JSONObject object = new JSONObject();

        try {
            object.put("robot-id", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that you would like to disable this robot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage("disable", object);
                Toast.makeText(DisableActivity.this, "Robot disabled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

    public void disableBlue2(View view) {
        final JSONObject object = new JSONObject();

        try {
            object.put("robot-id", 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Action");
        builder.setMessage("Please confirm that you would like to disable this robot");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ServerWriter.getInstance().sendMessage("disable", object);
                Toast.makeText(DisableActivity.this, "Robot disabled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null).show();
    }

}
