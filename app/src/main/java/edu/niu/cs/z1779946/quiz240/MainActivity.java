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
        finish();
    }

    public void addQuestion(View view){
        Intent intent = new Intent(MainActivity.this, InsertActivity.class);
        startActivity(intent);
        finish();
    }

    /*
    final Dialog dialog = new Dialog(StartActivity.this);
            dialog.setContentView(R.layout.login);
            dialog.setTitle("Login");
            final EditText editTextUserName = (EditText) dialog
                    .findViewById(R.id.editTextUserNameToLogin);
            final EditText editTextPassword = (EditText) dialog
                    .findViewById(R.id.editTextPasswordToLogin);

            Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

            btnSignIn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    String userName = editTextUserName.getText().toString();
                    String password = editTextPassword.getText().toString();
                    String storedPassword = loginDataBaseAdapter
                            .getSinlgeEntry(userName);
                    if (password.equals(storedPassword)) {
                        Toast.makeText(HomeActivity.this,
                                "Congrats: Login Successfull", Toast.LENGTH_LONG)
                                .show();
                        dialog.dismiss();
                        Intent main = new Intent(HomeActivity.this, Welcome.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(HomeActivity.this,
                                "User Name or Password does not match",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

            dialog.show();
    */

}
