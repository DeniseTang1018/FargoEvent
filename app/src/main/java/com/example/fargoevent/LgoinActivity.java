package com.example.fargoevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LgoinActivity extends AppCompatActivity {

    private EditText uName;
    private EditText password;
    private TextView attempts;
    private Button login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uName =  (EditText)findViewById(R.id.eTName);
        password = (EditText)findViewById(R.id.eTPassword);
        attempts = (TextView)findViewById(R.id.textView);
        login = (Button)findViewById(R.id.loginButton);

        attempts.setText("No. of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uName.getText().toString(),password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if(userName.equals("Admin")  && userPassword.equals("1234") ){

            Intent intent = new Intent(LgoinActivity.this, MainActivity.class);
            startActivity(intent);

        }else{
            counter--;

            attempts.setText("No. of attempts remaining: "+ String.valueOf(counter));
            if(counter == 0 ){
                login.setEnabled(false);
            }
        }
    }
}
