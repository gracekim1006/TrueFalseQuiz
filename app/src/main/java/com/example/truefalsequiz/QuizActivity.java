package com.example.truefalsequiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private TextView responseText;
    private Quiz quiz;
    private boolean answer;
    private String jsonString;
    private Button ButtonTrue;
    private Button ButtonFalse;
    private TextView Counter;
    private TextView Score;
    private String count = "";
    
    private void wireWidgets(){
        questionText = findViewById(R.id.textView_quiz_question);
        responseText = findViewById(R.id.textView_quiz_response);
        ButtonTrue = findViewById(R.id.button_quiz_true);
        ButtonFalse = findViewById(R.id.button_quiz_false);
        Counter = findViewById(R.id.textView_quiz_counter);
    }

    public static final String TAG = "QuizActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_quiz);
        super.onCreate(savedInstanceState);
        InputStream XmlFileInputStream= getResources().openRawResource(R.raw.questions);
        
        String jsonString = readTextFile(XmlFileInputStream);
        Log.d(TAG, "onCreate:" + jsonString);
        Gson gson = new Gson();
        Question[] question = gson.fromJson(jsonString, Question[].class);
        
        quiz = new Quiz(Arrays.asList(question));

        wireWidgets();
        loadQuestions();
        setListeners();
    }

    public void setListeners(){
        ButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadQuestions();
                if (quiz.getCurrentQuestion().getAnswer()==true){
                    responseText.setText("Correct!");
                    quiz.checkAnswer();
                    Counter.setText(String.valueOf(quiz.getCount()));
                }
                else{
                    responseText.setText("Incorrect!");
                }

            }
        });

        ButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadQuestions();
                if (quiz.getCurrentQuestion().getAnswer()==false){
                    responseText.setText("Correct!");
                    quiz.checkAnswer();
                    Counter.setText(String.valueOf(quiz.getCount()));
                }
                else{
                    responseText.setText("Incorrect!");
                }

            }
        });
    }


    private void loadQuestions(){
        if (quiz.hasMoreQuestions()){
            Question question = quiz.getNextQuestion();
            questionText.setText(question.getQuestion());
            answer = question.getAnswer();
    }
        else {
            Intent intent = new Intent(QuizActivity.this, FinalActivity.class);
            intent.putExtra("score", String.valueOf(quiz.getCount()));
            Log.d(TAG, "loadQuestions: "+quiz.getCount());
            startActivity(intent);
        }

    }


    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}

