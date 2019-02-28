package com.example.fargoevent.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fargoevent.Retrofit.Models.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME ="my_shared_preff";
    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx){
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx){
        if(mInstance ==null){
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", user.getUserName());
        editor.putString("password",user.getUserPassword());
        editor.putString("token",user.getToken());
        editor.putBoolean("loggedIn",User.isLoggedIn());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("loggedIn", false) != false;

    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        User user = new User(sharedPreferences.getString("username", null),sharedPreferences.getString("password",null));
        user.setToken(sharedPreferences.getString("token",null));
        return user;
    }

    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }


}
