package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpeningActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        ServerReader.init();
    }

    public void chooseRef(View view) {
        id = view.getTag().toString();
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
        this.finish();
    }

    public String getId() {
        return id;
    }

}
