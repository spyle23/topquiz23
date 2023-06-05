package com.spyle23.topquiz23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.spyle23.topquiz23.model.Question;
import com.spyle23.topquiz23.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTitle;
    private Button mQuestion1;
    private Button mQuestion2;
    private Button mQuestion3;
    private Button mQuestion4;

    private final QuestionBank questionBank = generateQuestionBank();

    public void displayQuestion(final Question question) {
        this.mQuestionTitle.setText(question.getQuestion());
        this.mQuestion1.setText(question.getChoiceList().get(0));
        this.mQuestion2.setText(question.getChoiceList().get(1));
        this.mQuestion3.setText(question.getChoiceList().get(2));
        this.mQuestion4.setText(question.getChoiceList().get(3));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.mQuestionTitle = findViewById(R.id.game_activity_textview_question);
        this.mQuestion1 = findViewById(R.id.game_activity_button_1);
        this.mQuestion2 = findViewById(R.id.game_activity_button_2);
        this.mQuestion3 = findViewById(R.id.game_activity_button_3);
        this.mQuestion4 = findViewById(R.id.game_activity_button_4);


        mQuestion1.setOnClickListener(this);
        mQuestion2.setOnClickListener(this);
        mQuestion3.setOnClickListener(this);
        mQuestion4.setOnClickListener(this);

        displayQuestion(questionBank.getCurrentQuestion());

    }

    public QuestionBank generateQuestionBank(){
        Question question1 = new Question(
                "Who is the creator of Android?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );

        Question question2 = new Question(
                "When did the first man land on the moon?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
        );

        Question question3 = new Question(
                "What is the house number of The Simpsons?",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3));
    }

    @Override
    public void onClick(View v) {
        int index;

        if (v == mQuestion1) {
            index = 0;
        } else if (v == mQuestion2) {
            index = 1;
        } else if (v == mQuestion3) {
            index = 2;
        } else if (v == mQuestion4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        if(index == this.questionBank.getCurrentQuestion().getAnswerIndex()){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}