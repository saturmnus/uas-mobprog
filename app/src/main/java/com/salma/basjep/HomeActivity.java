package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonHiragana = findViewById(R.id.button2);
        Button buttonKatakana = findViewById(R.id.button3);
        Button buttonBuahBuahan = findViewById(R.id.button4);
        Button buttonHewan = findViewById(R.id.button5);
        Button buttonPercakapan = findViewById(R.id.button6);
        Button buttonRuangPublik = findViewById(R.id.button7);
        Button buttonQuiz = findViewById(R.id.button8);

        buttonHiragana.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, HiraganaActivity.class);
            startActivity(intent);
        });

        buttonKatakana.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, KatakanaActivity.class);
            startActivity(intent);
        });

        buttonBuahBuahan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, BuahActivity.class);
            startActivity(intent);
        });

        buttonHewan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, HewanActivity.class);
            startActivity(intent);
        });

        buttonPercakapan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PercakapanActivity.class);
            startActivity(intent);
        });

        buttonRuangPublik.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PublikActivity.class);
            startActivity(intent);
        });

        buttonQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
            startActivity(intent);
        });
    }
}
