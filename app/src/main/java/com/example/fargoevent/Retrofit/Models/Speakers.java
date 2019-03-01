package com.example.fargoevent.Retrofit.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class is used for Retrofit speaker lists with default setters and getters using in Event class
 */
public class Speakers {
    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
