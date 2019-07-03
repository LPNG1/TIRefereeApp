package com.example.tirefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpeningActivity extends AppCompatActivity {

    private static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
    }

    public void chooseRef(View view) {
        id = view.getTag().toString();
        System.out.println(id);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
        this.finish();
    }

    public static String getId() {
        return id;
    }

}
