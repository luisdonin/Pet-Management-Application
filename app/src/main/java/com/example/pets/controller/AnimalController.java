package com.example.pets.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.model.Animal;
import com.example.pets.adapter.AnimalAdapter;
import com.example.pets.R;

import java.util.ArrayList;

/*
* May 26th, 2025.
* This is intended to be the registration screen for animals.
*  May 30th, 2025.
*  So, I remodeled the animal class
*  now I have to rebuild the controller
* */
public class AnimalController extends Fragment {
    EditText ownerName, ownerAddr, petName, breed;
    Spinner species, age;
    Button btnCreate, btnRead, btnEdit, btnDelete;

    AnimalAdapter adapter;

    private final ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_animals, container, false);
        ownerName = v.findViewById(R.id.pet_owner_name);
        ownerAddr = v.findViewById(R.id.pet_owner_address);
        species = v.findViewById(R.id.pet_species);
        breed = v.findViewById(R.id.pet_breed);
        age = v.findViewById(R.id.pet_animal_age);
        btnCreate = v.findViewById(R.id.btn_create);


        adapter = new AnimalAdapter(animalList);
        RecyclerView rv = v.findViewById(R.id.rv_animals);
        rv.setAdapter(adapter);

        btnCreate.setOnClickListener(view -> {
            Animal c = data();
            if (c != null) {
                adicionar(c);
            }
        });

        return v;
    }

    public Animal data( ) {

        String nameOwner = ownerName.getText().toString().trim();
        String ownerAddress = ownerAddr.getText().toString().trim();
        String namePet = petName.getText().toString().trim(); // I did this because then I wouldn't have to write getText().toString().trim() all the time.
        String petSpecies = String.valueOf(species);
        String petBreed = breed.getText().toString().trim();
        int agePet = Integer.parseInt(String.valueOf(age));

        if (nameOwner.isEmpty() || ownerAddress.isEmpty() || namePet.isEmpty() || petSpecies.isEmpty() || petBreed.isEmpty()) {
            Toast.makeText(getActivity(),"Preencher todos os campos!", Toast.LENGTH_SHORT).show();
            return null;
        }
        ownerName.setText("");
        ownerAddr.setText("");
        petName.setText("");
      //petOwnerAdresss.setText("");
     //petSpecies.setText("");
        breed.setText("");
        return new Animal(nameOwner, ownerAddress, namePet, petSpecies, petBreed, agePet);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void adicionar(Animal c) {
        animalList.add(c);
        adapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Animal saved!", Toast.LENGTH_SHORT).show();
    }


}
/*
* May 30th, 2025.
* I decided that I don't really need three classe to represent the animal
* So I axed the Species and Breed classes. AI tried to auto complete my comment but I denied it the pleasure.
* */