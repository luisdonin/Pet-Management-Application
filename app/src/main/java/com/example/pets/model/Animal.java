package com.example.pets.model;

import java.io.Serializable;
/*
* May 26th, 2025.
* This class represents an Animal with properties such as name, species, breed, city, and value.
* Now I'm going to create the Animal list on MainActivity.java
*
* */
public class Animal implements Serializable {

    private String name;



    private Human owner;
    private Species species;
    private Breed breed;
    public String city;




    public String age;

    public Animal(String name, Species species, Breed breed, String city, String age) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String value;
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}