package edu.niu.cs.z1779946.quiz240;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private EditText quizNoET, questionET, option1ET, option2ET, option3ET, option4ET, answerET;

    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        databaseManager = new DatabaseManager(this);
    }//end of onCreate

    public void insertQuestion(View view){
        quizNoET = (EditText)findViewById(R.id.quizNoEditText);
        questionET = (EditText)findViewById(R.id.questionEditText);
        option1ET = (EditText)findViewById(R.id.option1EditText);
        option2ET = (EditText)findViewById(R.id.option2EditText);
        option3ET = (EditText)findViewById(R.id.option3EditText);
        option4ET = (EditText)findViewById(R.id.option4EditText);
        answerET = (EditText)findViewById(R.id.answerEditText);

        String quizNoStr = quizNoET.getText().toString(),
               questionStr = questionET.getText().toString(),
               option1Str = option1ET.getText().toString(),
               option2Str = option2ET.getText().toString(),
               option3Str = option3ET.getText().toString(),
               option4Str = option4ET.getText().toString(),
               answerStr = answerET.getText().toString();

        String optionsStr;
        if (option3Str.isEmpty() && option4Str.isEmpty())
            optionsStr = option1Str + "|" + option2Str;
        else
            optionsStr = option1Str + "|" + option2Str + "|" + option3Str + "|" + option4Str;

        Question question = new Question(0, Integer.parseInt(quizNoStr), questionStr, optionsStr, answerStr);

        databaseManager.insert(question);

        Toast.makeText(InsertActivity.this, "Question Added", Toast.LENGTH_SHORT).show();
        quizNoET.setText("");
        questionET.setText("");
        option1ET.setText("");
        option2ET.setText("");
        option3ET.setText("");
        option4ET.setText("");
        answerET.setText("");
    }//end of insert

    public void back(View view){
        finish();
    }//emd of back

}//end of class
