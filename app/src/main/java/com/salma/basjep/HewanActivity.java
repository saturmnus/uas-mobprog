package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HewanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan);

        Button backButton = findViewById(R.id.button);

        backButton.setOnClickListener(v -> {

            Intent intent = new Intent(HewanActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
