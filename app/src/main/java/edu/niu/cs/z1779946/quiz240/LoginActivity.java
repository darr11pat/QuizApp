package edu.niu.cs.z1779946.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameET, passET;
    Button loginBT;
    String username;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = (EditText)findViewById(R.id.usernameEditText);
        passET = (EditText)findViewById(R.id.passwordEditText);

        databaseHelper = new DatabaseHelper(this);
    }//end of onCreate

    public void logIn(View view){
        String usernameStr = usernameET.getText().toString(),
                passwordStr = passET.getText().toString();

        Toast.makeText(this, " In Login ", Toast.LENGTH_SHORT).show();
        String success = databaseHelper.U_checkUser(usernameStr);
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show();

        if(success.equals(passwordStr)) {
            Toast.makeText(this, "Login Successfully ", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("display", usernameStr);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Username and password don't match! ", Toast.LENGTH_SHORT).show();
        }

    }//end of logIn

    public void signIn(View view){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }//end of SignIn
}
