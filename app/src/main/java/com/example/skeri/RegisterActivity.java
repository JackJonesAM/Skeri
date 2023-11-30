package com.example.skeri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText signUp_Email, signUp_Password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth  = FirebaseAuth.getInstance();

        signUp_Email = findViewById(R.id.signUp_Email);
        signUp_Password = findViewById(R.id.signUp_Password);
        Button signUp_btn = findViewById(R.id.signUp_btn);
        TextView logInRedirect = findViewById(R.id.logInRedirect);

        signUp_btn.setOnClickListener(v -> {
            String user = signUp_Email.getText().toString().trim();
            String pass = signUp_Password.getText().toString().trim();
            if (user.isEmpty()){
                signUp_Email.setError("Email cannot be empty");
            }
            if (pass.isEmpty()){
                signUp_Password.setError("Password cannot be empty");
            } else {
                mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Sign Up Successful",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,
                                LogInActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Sign Up Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        logInRedirect.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this,
                LogInActivity.class)));
    }
}