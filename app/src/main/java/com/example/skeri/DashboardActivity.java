package com.example.skeri;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    ImageView btnHome, btnMssg, btnAddpost;

    Button logOut;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find the ImageViews by their IDs
        btnHome = findViewById(R.id.btnHome);
        btnMssg = findViewById(R.id.btnMssg);
        btnAddpost = findViewById(R.id.btnAddpost);
        logOut = findViewById(R.id.logOut_btn);

        mAuth = FirebaseAuth.getInstance();


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
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }
    private void signOut() {

        mAuth.signOut();
        // Redirect to the login screen or any other appropriate activity
        Intent intent = new Intent(DashboardActivity.this, LogInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish(); // Close the current activity to prevent going back to it
    }

}