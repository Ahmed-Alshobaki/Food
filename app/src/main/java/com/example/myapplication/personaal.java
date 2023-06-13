package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentPersonaalBinding;

import DataBase.DataBase_food;
import DataBase.user;


public class personaal extends Fragment {

FragmentPersonaalBinding binding;

DataBase_food dataBase_food;
    private String data;
    singIN singIN;
    SharedPreferences preferencesE_p;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentPersonaalBinding.inflate(inflater, container, false);
        View v=  binding.getRoot();
            dataBase_food =new DataBase_food(getContext());
           user gg = dataBase_food.getUserById(1);
           binding.textView21.setText(gg.getName());
           binding.textEmailSeen.setText(gg.getEmail());
           binding.celebrityImage.setImageBitmap(gg.getImag());






        binding.Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent  intent = new Intent(getContext(),singIN.class);
               startActivity(intent);
            }
        });
        binding.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),edit_profile.class);
                intent.putExtra("name",binding.textView21.getText().toString());
                intent.putExtra("email",binding.textEmailSeen.getText().toString());
                user gg = dataBase_food.getUserById(1);

                intent.putExtra("id",gg.getId());

                startActivity(intent);
            }
        });

             return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        dataBase_food =new DataBase_food(getContext());
        user gg = dataBase_food.getUserById(1);
        binding.celebrityImage.setImageBitmap(gg.getImag());
    }
}