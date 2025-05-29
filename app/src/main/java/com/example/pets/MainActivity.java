package com.example.pets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pets.controller.AnimalController;
import com.example.pets.controller.HumanController;
import com.example.pets.model.Animal;

import java.util.ArrayList;


/*
* Sun, May 25th, 2025
* wow, now AI wants to finish even my comments, and it just did '-'
* Anyways, now I'm gonna configure the main screen of the app, which consists of:
* The name of the pet
* Their age
* And a bunch of buttons.
* 1st button: btn_manage_breed to manage the breeds
* 2nd button: btn_manage_city to manage the cities
* 3rd button: btn_manage_animal to manage the animals
* 4th button: btn_search_animal to search for an animal
*
* May 26th, 2025
* 1st Setting up the Animal class stuff and trying to register a species.
* */


public class MainActivity extends AppCompatActivity {



    ArrayList<Animal> animals = new ArrayList<>();
    AnimalController registerAnimalFragment = new AnimalController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnManageBreed = findViewById(R.id.btn_manage_breed);
        Button btnManageOwner= findViewById(R.id.btn_manage_owner);
        Button btnManageAnimal = findViewById(R.id.btn_manage_animal);
        Button btnSearch = findViewById(R.id.btn_search);

        btnManageBreed.setOnClickListener(v -> {
            //setContentView(R.layout.activity_manage_breeds);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new com.example.pets.controller.BreedController())
                    .commit();
            });


        btnManageAnimal.setOnClickListener(v -> getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new AnimalController())
                .commit());

        btnManageOwner.setOnClickListener(v -> getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HumanController())
                .commit());

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });


    }
   public void confirmar(View v) {
        if ( registerAnimalFragment != null) {
            Animal c = registerAnimalFragment.data();
            registerAnimalFragment.adicionar(c);
            /*if (c != null) {
                if (editando != null) {
                    fragLista.substituir(editando, c);
                } else {
                    fragLista.adicionar(c);
                }
                editando = null;
            }*/
        }
    }

}