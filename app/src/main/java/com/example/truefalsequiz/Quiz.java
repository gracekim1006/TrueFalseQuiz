package com.example.truefalsequiz;

import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int index= 0;
    private int count=0;

     Quiz(List<Question> questions){
        this.questions = questions;
    }

    public Question getCurrentQuestion(){
         return questions.get(index);
    }
    public Question getNextQuestion(){
        Question nextQ = questions.get(index);
        index++;
        return nextQ;
    }

    public Boolean hasMoreQuestions(){
        return questions.size() > index +2;
    }

    public int checkAnswer(){
        return count++;
    }

    public int getCount() {
        return count;
    }
}
