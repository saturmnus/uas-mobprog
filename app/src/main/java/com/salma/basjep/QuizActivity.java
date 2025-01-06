package com.salma.basjep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Inisialisasi komponen
        RadioGroup rgQuestion1 = findViewById(R.id.rgQuestion1);
        RadioGroup rgQuestion2 = findViewById(R.id.rgQuestion2);
        RadioGroup rgQuestion3 = findViewById(R.id.rgQuestion3);
        RadioGroup rgQuestion4 = findViewById(R.id.rgQuestion4);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // Jawaban yang benar
        int[] correctAnswers = {
                R.id.rbQ1Option1, // Usagi
                R.id.rbQ2Option2, // Terimakasih
                R.id.rbQ3Option2, // Ogenki Desuka?
                R.id.rbQ4Option1  // Sakuranbo
        };

        btnSubmit.setOnClickListener(view -> {
            int score = 0;

            // Jawaban yang dipilih pengguna
            int[] selectedAnswers = {
                    rgQuestion1.getCheckedRadioButtonId(),
                    rgQuestion2.getCheckedRadioButtonId(),
                    rgQuestion3.getCheckedRadioButtonId(),
                    rgQuestion4.getCheckedRadioButtonId()
            };

            // Periksa jawaban
            for (int i = 0; i < correctAnswers.length; i++) {
                if (selectedAnswers[i] == correctAnswers[i]) {
                    score++;
                }
            }

            // Tampilkan skor
            Toast.makeText(QuizActivity.this, "Nilai Anda: " + score + "/4", Toast.LENGTH_SHORT).show();

            // Pindah ke HomeActivity
            Intent intent = new Intent(QuizActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Mengakhiri QuizActivity agar tidak bisa kembali menggunakan tombol back
        });
    }
}
