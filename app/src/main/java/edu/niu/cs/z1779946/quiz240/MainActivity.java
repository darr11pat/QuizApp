package edu.niu.cs.z1779946.quiz240;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view){
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void addQuestion(View view){
        Intent intent = new Intent(MainActivity.this, InsertActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view){
        System.exit(1);
    }

}
