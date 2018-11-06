package com.example.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FinalActivity extends AppCompatActivity {
    private TextView score;
    private Quiz quiz;


    private void wireWidgets(){
        score = findViewById(R.id.textView_final_score);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_final);
        super.onCreate(savedInstanceState);

        wireWidgets();
        setContentView(R.layout.activity_final);
        String count = getIntent().getStringExtra("score");
        Log.d("final", "onCreate: "+count);
        score.setText("66tt");
        Log.d("final activity", "onCreate: "+ score.getText().toString());

    }

}
