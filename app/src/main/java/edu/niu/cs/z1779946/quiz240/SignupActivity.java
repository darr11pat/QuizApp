package edu.niu.cs.z1779946.quiz240;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private DatabaseManager databaseHelper;
    private EditText fullNameET, emailET, userNameET, passwordET, confirm_passwordET;
    private Button signUpBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullNameET = (EditText)findViewById(R.id.fullName);
        emailET = (EditText)findViewById(R.id.userEmailId);
        userNameET = (EditText)findViewById(R.id.userName);
        passwordET = (EditText)findViewById(R.id.password);
        confirm_passwordET = (EditText)findViewById(R.id.confirmPassword);

        databaseHelper = new DatabaseManager(this);
    }//end of onCreate

    public void signUpBtn(View view) {
        String fullNameSTR = fullNameET.getText().toString(),
                emailSTR = emailET.getText().toString(),
                userNameSTR = userNameET.getText().toString(),
                passwordSTR = passwordET.getText().toString(),
                confirmPasswordSTR = confirm_passwordET.getText().toString();

        if(fullNameSTR.equals("") && emailSTR.equals("") && userNameSTR.equals("") && passwordSTR.equals("")){
            Toast.makeText(SignupActivity.this, "Empty Fields!", Toast.LENGTH_SHORT).show();
        }else if (!passwordSTR.equals(confirmPasswordSTR))
            Toast.makeText(SignupActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(SignupActivity.this, "Got userdata!", Toast.LENGTH_SHORT).show();

            NewUser newUser = new NewUser(fullNameSTR, emailSTR, userNameSTR, passwordSTR);

            Toast.makeText(SignupActivity.this, "checking database", Toast.LENGTH_SHORT).show();

            databaseHelper.U_insertData(newUser);

            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
    }//end of signup

    public void login(View view){
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}//end of class
