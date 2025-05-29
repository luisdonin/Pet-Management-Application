package com.example.pets.api;

import com.example.pets.model.Animal;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PetsApi {
    @GET("animal")
    Call<List<Animal>> getAnimals();

    @GET("animal/{id}")
    Call<Animal> getAnimal(@Path("id") int id);
}