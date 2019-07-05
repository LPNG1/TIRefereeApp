package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeleteStackActivity extends AppCompatActivity {

    EditText stackId;
    TextView stackDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_stack);
        stackId = findViewById(R.id.stackChooser);
        stackDisplay = findViewById(R.id.selectedStack);
    }

    public void displayStack(View view) {
        int stackNum = Integer.parseInt(stackId.getText().toString());

        stackDisplay.setText("Selected Stack:\n");

        JSONArray cargo = new JSONArray();

        try {
            JSONObject stack = PostGameActivity.getInstance().getStacks().getJSONObject(stackNum);
            cargo = stack.getJSONArray("cargo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i <= cargo.length(); i++) {
                try {
                    JSONObject cargoType = cargo.getJSONObject(i);
                    stackDisplay.append(cargoType.getString("type") + "\n");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Toast.makeText(DeleteStackActivity.this, "This stack does not exist!", Toast.LENGTH_SHORT).show();
        }
    }

    public void removeStack(View view) {
        int stackNum = Integer.parseInt(stackId.getText().toString());
        PostGameActivity.getInstance().removeStack(stackNum);
    }

    public void finishDelete(View view) {
        finish();
    }

}
