package com.example.pets.model;

public class Breed implements java.io.Serializable {
    private String breedName;

    public Breed(String breedName) {
        this.breedName = breedName;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}