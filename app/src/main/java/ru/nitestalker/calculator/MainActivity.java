package ru.nitestalker.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int a = 10;
    private int b = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewQuestion = findViewById(R.id.textViewExample);
        TextView textViewIncorrectAnswer = findViewById(R.id.textViewIncorrectAnswer);
        TextView textViewCorrectAnswer = findViewById(R.id.textViewCorrectAnswer);

        textViewQuestion.setText(generateSumString(a, b));

        buttonAnswer.setOnClickListener(view -> {
            String text = editTextAnswer.getText().toString();
            if (text == null || text.equals("")) {
                Toast.makeText(this, "Empty answer!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (text.equals(String.valueOf(a + b))) {
                textViewIncorrectAnswer.setVisibility(View.INVISIBLE);
                textViewCorrectAnswer.setVisibility(View.VISIBLE);
                a = new Random().nextInt(100);
                b = new Random().nextInt(100);
                textViewQuestion.setText(generateSumString(a, b));
                editTextAnswer.setText("");
            }
            else {
                textViewCorrectAnswer.setVisibility(View.INVISIBLE);
                textViewIncorrectAnswer.setVisibility(View.VISIBLE);
            }
        });
    }

    private String generateSumString(int a, int b) {
        return a + " + " + b;
    }
}