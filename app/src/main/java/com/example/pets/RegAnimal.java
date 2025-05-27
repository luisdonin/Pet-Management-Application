package com.example.pets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
* May 26th, 2025.
* This is intended to be the registration screen for animals.
* */
public class RegAnimal extends Fragment {
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
        View v = inflater.inflate(R.layout.activity_manage_animals, container, false);
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

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal c = data();
                if (c != null) {
                    adicionar(c);
                }
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
        if (namePet == null || namePet.isEmpty() || agePet == null || breedPet == null || breedPet.isEmpty() || agePet.isEmpty() || ownerName == null || ownerName.isEmpty() || ownerAddress == null || ownerAddress.isEmpty() || speciesPet == null || speciesPet.isEmpty()) {
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
                new PetSpecies(speciesPet), // or PetSpecies.valueOf(speciesPet)
                new PetBreed(breedPet),     // or PetBreed.valueOf(breedPet)
                ownerAddress,
                agePet
        );
    }

    public void adicionar(Animal c) {
        animalList.add(c);
        adapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Animal saved!", Toast.LENGTH_SHORT).show();
    }

}
