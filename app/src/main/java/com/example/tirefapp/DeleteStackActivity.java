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

import java.util.ArrayList;

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
        int stackNum = Integer.parseInt(stackId.getText().toString()) - 1;

        stackDisplay.setText("Selected Stack:\n");

        ArrayList<String> selectedStack = PostGameActivity.getInstance().getStacks().get(stackNum);

        try {
            for (int i = 0; i <= selectedStack.size(); i++) {
                stackDisplay.append(selectedStack.get(i));
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
