package com.example.truefalsequiz;


public class Question {
    private Boolean answer;
    private String question;

    Question(String q1, boolean b) {
        this.answer = b;
        question = q1;

    }
        public Boolean getAnswer() {
            return answer;
        }
        
        public String getQuestion() {
            return question;
        }
    }

