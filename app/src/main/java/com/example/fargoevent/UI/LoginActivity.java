package com.example.fargoevent.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fargoevent.R;
import com.example.fargoevent.Retrofit.Api;
import com.example.fargoevent.Retrofit.Models.User;
import com.example.fargoevent.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText uName;
    private EditText password;
    private TextView attempts;
    private Button login;
    private int counter=5;
    private String token;


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


        Call<User> call = RetrofitClient.getInstance().getApi().login(userName,userPassword);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    // test if get the correct token Toast.makeText(LoginActivity.this,response.body().getToken(),Toast.LENGTH_SHORT).show();
                    token = response.body().getToken();
                    Intent intent = new Intent(LoginActivity.this, ListView.class);
                    intent.putExtra("token",token);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this,"Login is not correct! ",Toast.LENGTH_SHORT).show();
                    counter--;

                    attempts.setText("No. of attempts remaining: "+ String.valueOf(counter));
                    if(counter == 0 ){
                        login.setEnabled(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"error", Toast.LENGTH_SHORT).show();

            }
        });

      /*
      //login not using https

      if(userName.equals("Admin")  && userPassword.equals("1234") ){

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else{
            counter--;

            attempts.setText("No. of attempts remaining: "+ String.valueOf(counter));
            if(counter == 0 ){
                login.setEnabled(false);
            }
        }
        */
    }
}
