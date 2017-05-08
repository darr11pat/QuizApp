package edu.niu.cs.z1779946.quiz240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTV, resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTV = (TextView)findViewById(R.id.scoreTextView);
        scoreTV.setText(" You scored ");

        resultTV = (TextView)findViewById(R.id.resultTextView);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        int questionCount = intent.getIntExtra("Qcount", 0);
        int correctAnswers = intent.getIntExtra("correctAns", 0);

        String qCount = String.valueOf(questionCount);
        String cAns = String.valueOf(correctAnswers);

        resultTV.setText( cAns + "/" + qCount );

    }//end of onCreate

    public void returnToHome(View view){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }//end of return home

}//end of activity
