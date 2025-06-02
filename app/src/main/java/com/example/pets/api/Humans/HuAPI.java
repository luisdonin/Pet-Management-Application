package com.example.pets.api.Humans;

import java.util.List;

import com.example.pets.model.Human;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HuAPI {
    @GET("human")
    Call<List<Human>> getHuman();

    @GET("Human/{id}")
    Call<Human> getHuman(@Path("id") int id);
}