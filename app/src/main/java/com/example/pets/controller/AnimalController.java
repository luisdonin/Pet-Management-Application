package com.example.pets.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.model.Species;
import com.example.pets.model.Animal;
import com.example.pets.adapter.AnimalAdapter;
import com.example.pets.model.Breed;
import com.example.pets.R;

import java.util.ArrayList;

/*
* May 26th, 2025.
* This is intended to be the registration screen for animals.
* */
public class AnimalController extends Fragment {
    EditText petName, petAge, petOwnerName, petOwnerAdresss, petSpecies, petBreed;
    Button btnCreate, btnRead, btnEdit, btnDelete;

    AnimalAdapter adapter;

    private ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_animals, container, false);
        petName = v.findViewById(R.id.pet_animal_name);
        petAge = v.findViewById(R.id.pet_animal_age);
        petOwnerName = v.findViewById(R.id.pet_owner_name);
        petOwnerAdresss = v.findViewById(R.id.pet_owner_address);
        petSpecies = v.findViewById(R.id.pet_species);
        petBreed = v.findViewById(R.id.pet_breed);
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
        String namePet = petName.getText().toString().trim();
        String agePet = petAge.getText().toString().trim();
        String breedPet = petBreed.getText().toString().trim();
        String ownerName = petOwnerName.getText().toString().trim();
        String ownerAddress = petOwnerAdresss.getText().toString().trim();
        String speciesPet = petSpecies.getText().toString().trim();
        if (namePet.isEmpty() || breedPet.isEmpty() || agePet.isEmpty() || ownerName.isEmpty() || ownerAddress.isEmpty() || speciesPet.isEmpty()) {
            Toast.makeText(getActivity(),"Preencher todos os campos!", Toast.LENGTH_SHORT).show();
            return null;
        }
        petName.setText("");
        petAge.setText("");
        petOwnerName.setText("");
        petOwnerAdresss.setText("");
        petSpecies.setText("");
        petBreed.setText("");
        return new Animal(
                namePet,
                new Species(speciesPet),
                new Breed(breedPet),
                ownerAddress,
                agePet
        );
    }

    @SuppressLint("NotifyDataSetChanged")
    public void adicionar(Animal c) {
        animalList.add(c);
        adapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Animal saved!", Toast.LENGTH_SHORT).show();
    }


}
