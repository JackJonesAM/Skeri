package com.example.skeri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    ImageView btnHome, btnMssg, btnAddpost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find the ImageViews by their IDs
        btnHome = findViewById(R.id.btnHome);
        btnMssg = findViewById(R.id.btnMssg);
        btnAddpost = findViewById(R.id.btnAddpost);


        btnHome.setOnClickListener(v -> {
            // Replace MessageActivity.class with the target activity class
            Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        btnMssg.setOnClickListener(view -> {
            Intent intent = new Intent(DashboardActivity.this, MessageActivity.class);
            startActivity(intent);
        });

        btnAddpost.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ComposeActivity.class);
            startActivity(intent);
        });
    }
}
