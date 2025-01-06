package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PublikActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publik);

        Button backButton = findViewById(R.id.button);

        backButton.setOnClickListener(v -> {

            Intent intent = new Intent(PublikActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
