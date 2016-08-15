package com.example.suketurastogi.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupAnswerOne;
    RadioGroup radioGroupAnswerTwo;
    RadioGroup radioGroupAnswerThree;

    EditText answerFiveEditText;

    CheckBox questionFourCheckBoxOne;
    CheckBox questionFourCheckBoxTwo;
    CheckBox questionFourCheckBoxThree;
    CheckBox questionFourCheckBoxFour;

    Boolean answerOne = false;
    Boolean answerTwo = false;
    Boolean answerThree = false;
    Boolean answerFour = false;
    String answerFive;

    Integer totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Initialize Radio Group and attach click handler
        radioGroupAnswerOne = (RadioGroup) findViewById(R.id.question_one_radio_group);
        radioGroupAnswerOne.clearCheck();

        radioGroupAnswerTwo = (RadioGroup) findViewById(R.id.question_two_radio_group);
        radioGroupAnswerTwo.clearCheck();

        radioGroupAnswerThree = (RadioGroup) findViewById(R.id.question_three_radio_group);
        radioGroupAnswerThree.clearCheck();

        radioGroupAnswerOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Checking For correct option
                if (i == R.id.question_one_answer) {
                    answerOne = true;
                } else {
                    answerOne = false;
                }
            }
        });

        radioGroupAnswerTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // Checking For correct option
                if (i == R.id.question_two_answer) {
                    answerTwo = true;
                } else {
                    answerTwo = false;
                }

            }
        });

        radioGroupAnswerThree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // Checking For correct option
                if (i == R.id.question_three_answer) {
                    answerThree = true;
                } else {
                    answerThree = false;
                }
            }
        });

//      Initialize CheckBox For Question 4

        questionFourCheckBoxOne = (CheckBox) findViewById(R.id.question_four_checkbox_one);
        questionFourCheckBoxTwo = (CheckBox) findViewById(R.id.question_four_checkbox_two);
        questionFourCheckBoxThree = (CheckBox) findViewById(R.id.question_four_checkbox_three);
        questionFourCheckBoxFour = (CheckBox) findViewById(R.id.question_four_checkbox_four);

//      Initialize EditText For Question 5

        answerFiveEditText = (EditText) findViewById(R.id.answer_five);

    }

    public void checkResult() {

//      Checking For All Answers and Calculating Total Score Points

        if (answerOne) {
            totalScore = totalScore + 1;
        } else {
            totalScore = totalScore - 1;
        }

        if (answerTwo) {
            totalScore = totalScore + 1;
        } else {
            totalScore = totalScore - 1;
        }

        if (answerThree) {
            totalScore = totalScore + 1;
        } else {
            totalScore = totalScore - 1;
        }

        if (questionFourCheckBoxOne.isChecked() && questionFourCheckBoxTwo.isChecked() &&
                questionFourCheckBoxThree.isChecked() && !questionFourCheckBoxFour.isChecked()) {
            answerFour = true;
        } else {
            answerFour = false;
        }

        if (answerFour) {
            totalScore = totalScore + 1;
        } else {
            totalScore = totalScore - 1;
        }

        answerFive = answerFiveEditText.getText().toString();

        if (answerFive.equalsIgnoreCase("Software Development Kit")) {
            totalScore = totalScore + 1;
        } else {
            totalScore = totalScore - 1;
        }

    }

    public void onClear(View v) {

//      Clears all answers values
        answerOne = false;
        answerTwo = false;
        answerThree = false;
        answerFour = false;
        answerFive = null;

//      Clears all selected radio buttons to default
        radioGroupAnswerOne.clearCheck();
        radioGroupAnswerTwo.clearCheck();
        radioGroupAnswerThree.clearCheck();

//      Clears all selected CheckBox  to default
        questionFourCheckBoxOne.setChecked(false);
        questionFourCheckBoxTwo.setChecked(false);
        questionFourCheckBoxThree.setChecked(false);
        questionFourCheckBoxFour.setChecked(false);

//      Clears EditText to default
        answerFiveEditText.getText().clear();

//      Setting Score to Zero
        totalScore = 0;
    }

    public void onSubmitResult(View view) {

        checkResult();

//      Showing Total Score on Toast
        Toast.makeText(MainActivity.this, "Your Total Score Is : " + totalScore, Toast.LENGTH_LONG).show();

        onClear(view);
    }
}
