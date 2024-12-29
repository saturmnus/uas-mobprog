package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.salma.basjep.database.AppDatabase;
import com.salma.basjep.models.User;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutEmail, inputLayoutUsername, inputLayoutPassword;
    private TextInputEditText editTextEmail, editTextUsername, editTextPassword;
    private Button buttonRegister;

    private AppDatabase appDatabase; // Database instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputLayoutEmail = findViewById(R.id.inputLayoutEmail);
        inputLayoutUsername = findViewById(R.id.inputLayoutUsername);
        inputLayoutPassword = findViewById(R.id.inputLayoutPassword);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        // Initialize database
        appDatabase = AppDatabase.getInstance(this);

        // Set up register button click listener
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate inputs before proceeding
                if (validateInputs()) {
                    // Get input data
                    String email = editTextEmail.getText().toString().trim();
                    String username = editTextUsername.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();

                    // Create a new User object
                    User user = new User(username, email, password);

                    // Save user to the database
                    saveUserToDatabase(user);

                    // Navigate to LoginActivity after successful registration
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                    // Optionally, finish MainActivity to prevent going back to the registration screen
                    finish();
                }
            }
        });
    }

    // Validate user input for email, username, and password
    private boolean validateInputs() {
        boolean isValid = true;

        // Validate email
        if (editTextEmail.getText().toString().trim().isEmpty()) {
            inputLayoutEmail.setError("Email is required");
            isValid = false;
        } else {
            inputLayoutEmail.setError(null); // Clear error if input is valid
        }

        // Validate username
        if (editTextUsername.getText().toString().trim().isEmpty()) {
            inputLayoutUsername.setError("Username is required");
            isValid = false;
        } else {
            inputLayoutUsername.setError(null); // Clear error if input is valid
        }

        // Validate password
        if (editTextPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError("Password is required");
            isValid = false;
        } else {
            inputLayoutPassword.setError(null); // Clear error if input is valid
        }

        return isValid;
    }

    // Save user data to the database
    private void saveUserToDatabase(final User user) {
        // Perform database operations in a separate thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    appDatabase.userDao().insertUser(user);
                    Log.d("Register", "Saved User: " + user.getUsername() + ", " + user.getPassword());

                    runOnUiThread(() -> Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show());
                } catch (Exception e) {
                    runOnUiThread(() -> Toast.makeText(MainActivity.this, "Error: User already exists.", Toast.LENGTH_SHORT).show());
                }
            }
        }).start();
        new Thread(() -> {
            User existingUser = appDatabase.userDao().getUserByUsername(user.getUsername());
            if (existingUser != null) {
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Username already exists!", Toast.LENGTH_SHORT).show());
            } else {
                appDatabase.userDao().insertUser(user);
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show());
            }
        }).start();

    }
}
