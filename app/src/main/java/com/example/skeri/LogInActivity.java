    package com.example.skeri;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Patterns;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.google.android.gms.tasks.OnFailureListener;
    import com.google.android.gms.tasks.OnSuccessListener;
    import com.google.firebase.auth.AuthResult;
    import com.google.firebase.auth.FirebaseAuth;
    import com.google.firebase.auth.FirebaseUser;

    public class LogInActivity extends AppCompatActivity {

        private EditText logIn_Email, logIn_Password;
        private Button loginButton;
        private TextView signUpRedirect;
        private FirebaseAuth auth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_in);

            logIn_Email = findViewById(R.id.logIn_Email);
            logIn_Password = findViewById(R.id.logIn_Password);
            loginButton = findViewById(R.id.loginButton);
            signUpRedirect = findViewById(R.id.signUpRedirect);

            auth = FirebaseAuth.getInstance();



            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = logIn_Email.getText().toString();
                    String pass = logIn_Password.getText().toString();
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        if (!pass.isEmpty()) {
                            auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
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


            @Override
            public void onStart() {
                super.onStart();
                // Check if user is signed in (non-null) and update UI accordingly.
                FirebaseUser currentUser = mAuth.getCurrentUser();
                updateUI(currentUser);
            }

            private void updateUI(FirebaseUser user) {
                // Your implementation of updateUI
                // This is where you handle UI updates based on the user's authentication status
                // For example, you might navigate to a different activity or show relevant information.
                // Make sure to implement this method according to your app's logic.
            }

        }
    }