package com.example.quizgame;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Lisbon"}, 1));
        questions.add(new Question("What is 5 + 7?", new String[]{"10", "12", "13", "15"}, 1));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"Shakespeare", "Tolstoy", "Hemingway", "Poe"}, 0));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 2));

        return questions;
    }
}
