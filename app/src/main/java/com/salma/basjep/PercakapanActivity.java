package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PercakapanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percakapan);

        Button backButton = findViewById(R.id.button);

        backButton.setOnClickListener(v -> {

            Intent intent = new Intent(PercakapanActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}