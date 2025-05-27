package com.example.pets;

public class PetBreed implements java.io.Serializable {
    private String breedName;

    public PetBreed(String breedName) {
        this.breedName = breedName;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}