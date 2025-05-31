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

import com.example.pets.R;
import com.example.pets.model.Human;

import java.util.ArrayList;

public class HumanController extends Fragment {


    EditText ownerName, ownerAddr;
    Button btnCreate;
    private final ArrayList<Human> humanList = new ArrayList<>();
    HumanAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_owner, container, false);
        ownerName = v.findViewById(R.id.owner_name_input);
        ownerAddr = v.findViewById(R.id.owner_address_input);

        btnCreate = v.findViewById(R.id.save_owner_button);

        adapter = new HumanAdapter(humanList);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView rv = v.findViewById(R.id.rv_breeds);
        rv.setAdapter(adapter);
        btnCreate.setOnClickListener(view -> {
            Human human = data();
            if(human != null){
                adicionar(human);
            } else {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}




/* May, 30th, 2025 */
/* Thought Process */
/* First I get the variables from the layout
*
* Then I create an adapter
* * Then I set the adapter to the RecyclerView
* * Then I set the onClickListener for the create button
* * then I create the methods for the CRUD operations
*
*
* */