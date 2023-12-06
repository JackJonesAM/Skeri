    package com.example.skeri;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Patterns;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.gms.tasks.OnFailureListener;
    import com.google.android.gms.tasks.OnSuccessListener;
    import com.google.firebase.auth.AuthResult;
    import com.google.firebase.auth.FirebaseAuth;

    public class LogInActivity extends AppCompatActivity {

        private EditText logIn_Email, logIn_Password;
        private FirebaseAuth mAuth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_in);

            logIn_Email = findViewById(R.id.logIn_Email);
            logIn_Password = findViewById(R.id.logIn_Password);
            Button loginButton = findViewById(R.id.loginButton);
            TextView signUpRedirect = findViewById(R.id.signUpRedirect);

            mAuth = FirebaseAuth.getInstance();



            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = logIn_Email.getText().toString();
                    String pass = logIn_Password.getText().toString();
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        if (!pass.isEmpty()) {
                            mAuth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LogInActivity.this, "Login Successful",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LogInActivity.this,
                                            DashboardActivity.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(LogInActivity.this, "Login Failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            logIn_Password.setError("Empty fields are are not allowed");
                        }
                    } else if (email.isEmpty()) {
                        logIn_Email.setError("Empty fields not allowed");
                    } else {
                        logIn_Email.setError("Please enter correct email");
                    }
                }
            });

            signUpRedirect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LogInActivity.this, RegisterActivity.class));
                }
            });


        }

    }