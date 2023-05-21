package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivitySignup2Binding;
import com.example.myapplication.databinding.ActivitySingInBinding;

public class singIN extends AppCompatActivity {
ActivitySingInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySingInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(singIN.this, add.class);
                startActivity(intent);
            }
        });
    }
}