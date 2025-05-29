package com.example.pets.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.pets.R;

/*
* May 28th, 2025.
* After an unaccounted amount of time
* A bowl of pasta
* A few glasses of wine
* I finally understand what I'm trying to do
* ** Narrator **
* He didn.'t.
* */
public class BreedController extends Fragment {
    EditText breedName;

    Button btnCreate, btnRead, btnUpdate, btnDelete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_breeds, container, false);
        breedName = v.findViewById(R.id.pet_breed_name);
        btnCreate = v.findViewById(R.id.btn_create_breed);
        btnRead = v.findViewById(R.id.btn_read_breed);
        btnUpdate = v.findViewById(R.id.btn_update_breed);
        btnDelete = v.findViewById(R.id.btn_delete_breed);



        return v;
    }


}
