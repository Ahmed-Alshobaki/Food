package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentFavoritessBinding;
import com.example.myapplication.databinding.FragmentPersonaalBinding;

import DataBase.DataBase_food;
import adapter.adapterFood;


public class favoritess extends Fragment {

   FragmentFavoritessBinding binding;
    DataBase_food dataBase_food;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentFavoritessBinding.inflate(inflater, container, false);
        View v=  binding.getRoot();
        DataBase_food dataBase_food= new DataBase_food(getContext());
        adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.SearchFood_like(), new adapterFood.onclick() {
            @Override
            public void onitem(int position) {
                Intent intent=new Intent(getContext(),Details.class);
                intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                startActivity(intent);
            }

            @Override
            public void onitemlike(int position) {

            }
        });
        binding.recyclerview.setAdapter(adapterFood_Pizza);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);

        return v;

    }

}