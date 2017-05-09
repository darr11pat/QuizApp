package edu.niu.cs.z1779946.quiz240;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameET, passET;
    Button loginBT;
    String username;
    private DatabaseManager databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseManager(this);
    }//end of onCreate

    public void logIn(View view){
        usernameET = (EditText)findViewById(R.id.usernameEditText);
        passET = (EditText)findViewById(R.id.passwordEditText);

        String usernameStr = usernameET.getText().toString(),
                passwordStr = passET.getText().toString();

/*        Toast.makeText(LoginActivity.this, passET.getText().toString() + " " + passwordStr, Toast.LENGTH_SHORT).show();
        Toast.makeText(LoginActivity.this, usernameET.getText().toString() + " " + usernameStr, Toast.LENGTH_SHORT).show();*/

        if (usernameStr.isEmpty() && passwordStr.isEmpty()) {
            Toast.makeText(this, " In Login ", Toast.LENGTH_SHORT).show();
            String success = databaseHelper.U_checkUser(usernameStr);
            Toast.makeText(this, success, Toast.LENGTH_SHORT).show();

            if (success.equals(passwordStr)) {
                Toast.makeText(this, "Login Successfully ", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("display", usernameStr);
                startActivity(intent);
                finish();
            } else if (success.equals("NOT EXIST")) {
                Toast.makeText(this, "Username and password don't match! ", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(LoginActivity.this, "Enter Login Details", Toast.LENGTH_SHORT).show();
        }

    }//end of logIn

    public void signIn(View view){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
        finish();
    }//end of SignIn

    public void skipLogin(View view){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }//end of skip login
}
