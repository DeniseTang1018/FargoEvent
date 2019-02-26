package com.example.fargoevent.Retrofit;


import com.example.fargoevent.Retrofit.Models.Event;
import com.example.fargoevent.Retrofit.Models.ListItem;
import com.example.fargoevent.Retrofit.Models.Speaker;
import com.example.fargoevent.Retrofit.Models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("login")
    Call<User> login(

            @Field("Username") String userName,
            @Field("Password") String userPassword
    );

    @GET("events")
    Call<List<ListItem>> getEvents(
            @Header("Authorization") String authToken
    );

    @GET("speakers/{id}")
    Call<Speaker> getSpeaker(
            @Header("Authorization") String authToken,
            @Path("id") int id
    );

    @GET("events/{id}")
    Call<Event> getEvent(
            @Header("Authorization")String authToken,
            @Path("id") int id
    );

}
