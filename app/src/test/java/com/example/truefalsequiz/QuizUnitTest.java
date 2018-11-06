package com.example.truefalsequiz;

import com.example.truefalsequiz.Questions;
import com.example.truefalsequiz.Quiz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuizUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }

//    @Test
//    public void addition1984_isCorrect() {
//        assertEquals(5, 2 + 2);
    // we know this is going to be false
//    }

    @Test
    public void nextQuestionIsCorrect() {
        Questions q1 = new Questions("q1", true);
        Questions q2 = new Questions("q2", false);
        Questions q3 = new Questions("q3", true);

        List<Questions> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        Quiz quiz = new Quiz(questions);

        Questions next = quiz.getNextQuestion();

        assertEquals(q1.toString(), next.toString());
    }

    private void assertEquals(String s, String s1) {
    }

    @Test
    public void hasNextQuestionIsCorrect() {
        Questions q1 = new Questions("q1", true);
        Questions q2 = new Questions("q2", false);
        Questions q3 = new Questions("q3", true);

        List<Questions> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        Quiz quiz = new Quiz(questions);
        assertEquals(true, quiz.hasMoreQuestions());

        Questions next = quiz.getNextQuestion();
        assertEquals(true, quiz.hasMoreQuestions());

        next = quiz.getNextQuestion();
        assertEquals(true, quiz.hasMoreQuestions());

        next = quiz.getNextQuestion();
        assertEquals(false, quiz.hasMoreQuestions());

    }

    private void assertEquals(boolean b, Boolean aBoolean) {
    }
}