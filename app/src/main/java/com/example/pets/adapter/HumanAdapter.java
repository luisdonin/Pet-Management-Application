package com.example.pets.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HumanAdapter extends RecycleView.Adapter<HumanAdapter.HumanViewHolder> {
    

    
    public static class HumanViewHolder extends RecyclerView.ViewHolder {
        

        public HumanViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views

        }
    }

    @NonNull
    @Override
    public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new HumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanViewHolder holder, int position) {
        Human human = animalList.get(position);
        holder.textView.setText(human.getName());
    }

    @Override
    public int getItemCount() {
        return humanList.size();
    }

    public static class HumanViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public HumanViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

}
/* May 30th, 2025, 11:40 */
/* Bulding my Adapter */

/*
    * I've been doing this for a few hours
    * I have left my chair and second monitor
    * For the warm and cozy heat of my blanket
    * And the comfort of my sofa
    * Now, this is making me sleepy
    * It's really damn cold
    * I'm debating whether I should soldier on and continue my adapter
    * Or if I comit this now and start fresh tomorrow afternoon
*/
