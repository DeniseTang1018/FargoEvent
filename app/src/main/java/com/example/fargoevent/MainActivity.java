package com.example.fargoevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText uName;
    private EditText password;
    private TextView attempts;
    private Button loglin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uName =  (EditText)findViewById(R.id.eTName);
        password = (EditText)findViewById(R.id.eTPassword);
        attempts = (TextView)findViewById(R.id.textView);
        loglin = (Button)findViewById(R.id.lginButton);
    }

    private void validate(String userName, String userPassword){
        if(userName == "Admin" && userPassword == "1234"){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        }
    }
}
