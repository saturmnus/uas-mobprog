package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BuahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);

        Button backButton = findViewById(R.id.button);

        backButton.setOnClickListener(v -> {

            Intent intent = new Intent(BuahActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
