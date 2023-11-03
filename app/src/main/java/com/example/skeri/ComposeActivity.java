package com.example.skeri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ComposeActivity extends AppCompatActivity {
    ImageView btnHome;
    ImageView btnMssg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        // Find the ImageViews by their IDs
        btnHome = findViewById(R.id.btnHome);
        btnMssg = findViewById(R.id.btnMssg);



        btnHome.setOnClickListener(v -> {
            // Replace MessageActivity.class with the target activity class
            Intent intent = new Intent(ComposeActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        btnMssg.setOnClickListener(view -> {
            Intent intent = new Intent(ComposeActivity.this, MessageActivity.class);
            startActivity(intent);
        });

    }
}
