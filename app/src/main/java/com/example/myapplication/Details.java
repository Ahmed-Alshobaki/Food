package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.DetailsBinding;



public class Details extends AppCompatActivity {
DetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =DetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}