package com.example.skeri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ConversationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        ImageView arrow_return = findViewById(R.id.arrow_return);
        arrow_return.setOnClickListener(v -> finish());

    }
}