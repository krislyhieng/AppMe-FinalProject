package com.krislyhieng.appme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameEditText, phoneEditText, passwordEditText;
    private Button signupButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI components
        usernameEditText = findViewById(R.id.signupUsernameEditText);
        phoneEditText = findViewById(R.id.phone_number);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.signup_button);
        loginLink = findViewById(R.id.login_link);

        // Set click listener for sign up button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input from EditText fields
                String username = usernameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();

                // Perform signup logic here (e.g., validation and database operations)
                // For demonstration purposes, show a toast message
                Toast.makeText(SignupActivity.this, "Signed up successfully", Toast.LENGTH_SHORT).show();

                // Navigate to login screen after successful signup
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish current activity so user cannot navigate back to signup screen
            }
        });

        // Set click listener for login link TextView
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to login screen
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish current activity so user cannot navigate back to signup screen
            }
        });
    }
}
