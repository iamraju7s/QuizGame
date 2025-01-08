package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private RadioGroup optionsGroup;
    private Button nextButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        nextButton = findViewById(R.id.nextButton);

        questions = QuestionBank.getQuestions();
        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                currentQuestionIndex++;

                if (currentQuestionIndex < questions.size()) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void loadQuestion() {
        Question q = questions.get(currentQuestionIndex);
        questionText.setText(q.getQuestion());

        optionsGroup.removeAllViews();
        for (int i = 0; i < q.getOptions().length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(q.getOptions()[i]);
            radioButton.setId(i);
            optionsGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        if (selectedId == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
    }
}
