package com.example.skeri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {


    ImageView btnHome;
    RelativeLayout memMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btnHome = findViewById(R.id.btnHome);
        memMsg = findViewById(R.id.memMsg);

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        memMsg.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, ConversationActivity.class);
            startActivity(intent);
        });


    }
}