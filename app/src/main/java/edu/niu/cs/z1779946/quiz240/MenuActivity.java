package edu.niu.cs.z1779946.quiz240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button quiz1BT, quiz2BT, quiz3BT, quiz4BT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        quiz1BT = (Button)findViewById(R.id.quiz1Button);
        quiz2BT = (Button)findViewById(R.id.quiz2Button);
        quiz3BT = (Button)findViewById(R.id.quiz3Button);
        quiz4BT = (Button)findViewById(R.id.quiz4Button);

    }//end of onCreate

    public void quizOnClick(View view){
        switch(view.getId())
        {
            case R.id.quiz1Button:
                // Code for button 1 click
                startQuiz(1);
                break;

            case R.id.quiz2Button:
                // Code for button 2 click
                startQuiz(2);
                break;

            case R.id.quiz3Button:
                // Code for button 3 click
                startQuiz(3);
                break;
            case R.id.quiz4Button:
                // Code for button 4 click
                startQuiz(4);
                break;
        }//end of switch
    }//end of click event

    public void startQuiz(int id){
        Intent intent = new Intent(MenuActivity.this, StartActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

}//end of class
