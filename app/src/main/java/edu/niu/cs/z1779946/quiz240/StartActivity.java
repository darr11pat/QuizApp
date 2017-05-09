package edu.niu.cs.z1779946.quiz240;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;

    private ArrayList<Question> questions;

    private int questionsCount, currentQuestionIndex = -1, correctAnswers = 0;
    private Question nextQuestion, currentQuestion;

    private TextView questionTV;
    private RadioGroup optionsRG;
    private RadioButton option1RB, option2RB, option3RB, option4RB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        questionTV = (TextView)findViewById(R.id.questionTextView);
        optionsRG = (RadioGroup) findViewById(R.id.optionsRadioGroup);
        option1RB = (RadioButton)findViewById(R.id.option1RadioButton);
        option2RB = (RadioButton)findViewById(R.id.option2RadioButton);
        option3RB = (RadioButton)findViewById(R.id.option3RadioButton);
        option4RB = (RadioButton)findViewById(R.id.option4RadioButton);

        databaseManager = new DatabaseManager(this);

//        Toast.makeText(this," In Start activity", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);

        questions = databaseManager.selectAllById(id);
        questionsCount = questions.size();

        if(questionsCount > 0) {
            updateView();
        } else {
            Toast.makeText(StartActivity.this, " No questions left, Select another Quiz ", Toast.LENGTH_SHORT).show();
        }
    }//end onCreate

    public void getNextQuestion(){
        currentQuestionIndex++;

        //if at the end go back to beginning
        if(currentQuestionIndex >= questionsCount){
            Intent intent = new Intent(StartActivity.this, ResultActivity.class);

            Bundle extras = new Bundle();
            extras.putInt("Qcount", questionsCount);
            extras.putInt("correctAns", correctAnswers);

            intent.putExtras(extras);
            startActivity(intent);
            finish();
        }

        currentQuestion = questions.get(currentQuestionIndex);
    }//end of getNextQuestion


    public void updateView(){
        getNextQuestion();

        questionTV.setText(currentQuestion.getQuestion());

//        Toast.makeText(this," Added question to view" + currentQuestion.getQuestion(), Toast.LENGTH_SHORT).show();

        String options = currentQuestion.getOptions();
        String[] choices = options.split("\\|");

        if (choices.length == 4){
            option3RB.setEnabled(true);
            option4RB.setEnabled(true);

            option1RB.setText(choices[0]);
            option2RB.setText(choices[1]);
            option3RB.setText(choices[2]);
            option4RB.setText(choices[3]);

        }else if (choices.length == 2){
            option3RB.setText("");
            option4RB.setText("");
            option3RB.setEnabled(false);
            option4RB.setEnabled(false);

            option1RB.setText(choices[0]);
            option2RB.setText(choices[1]);

        } else if (choices.length == 3){
            option4RB.setText("");
            option4RB.setEnabled(false);

            option1RB.setText(choices[0]);
            option2RB.setText(choices[1]);
            option3RB.setText(choices[2]);
        }//end of if-else

    }//end of update view

    public void nextQuestionButton(View view){

        if (optionsRG.getCheckedRadioButtonId() == -1){
            Toast.makeText(StartActivity.this, "Select an answer", Toast.LENGTH_SHORT).show();
        } else {
            String answer = ((RadioButton)findViewById(optionsRG.getCheckedRadioButtonId())).getText().toString();

            if (answer.equals(currentQuestion.getAnswer())) {
                correctAnswers++;
                optionsRG.clearCheck();
                updateView();
            }
        }

    }//end of nextQuestion button click

}//end of main activity
