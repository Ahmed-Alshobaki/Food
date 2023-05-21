package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.WelcomeBinding;

public class MainActivity3 extends AppCompatActivity {
WelcomeBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(MainActivity3.this,singIN.class);
            startActivity(intent);
            }
        });
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,SIGNUP.class);
                startActivity(intent);

            }
        });

    }
}