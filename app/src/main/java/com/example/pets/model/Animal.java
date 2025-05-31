package com.example.pets.model;

import java.io.Serializable;
/*
* May 26th, 2025.
* This class represents an Animal with properties such as name, species, breed, city, and value.
* Now I'm going to create the Animal list on MainActivity.java
*  May 30th, 2025.
* Here I am again, remodelling again
* But it'll work this time
* Because now I know what I'm doing
* Yes, my model will mirror my frontend because it's easier to work with images
* */
public class Animal implements Serializable {
    private String owner;
    private String ownerAddress;
    private String name;
    private String species;
    private String breed;
    private int age;

    public Animal(String owner, String ownerAddress, String name, String species, String breed, int age) {
        this.owner = owner;
        this.ownerAddress = ownerAddress;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}