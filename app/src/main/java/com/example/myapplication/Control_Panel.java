package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityControlPanelBinding;
import com.example.myapplication.databinding.ActivitySingInBinding;

public class Control_Panel extends AppCompatActivity {

    ActivityControlPanelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityControlPanelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addNewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplication(),Add_new_products.class);
                startActivity(intent);
            }
        });
    }
}