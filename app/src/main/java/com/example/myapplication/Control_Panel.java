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
        Intent intent = getIntent();
        intent.getStringExtra("email");
        intent.getStringExtra("p");



        binding.addNewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplication(),Add_new_products.class);
                startActivity(intent);
            }
        });
        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Control_Panel.this,singIN.class);
                startActivity(intent);
            }
        });
            binding.EditProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Control_Panel.this,edit_admin_food_item.class);
                    startActivity(intent);
                }
            });
            binding.profileAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Control_Panel.this,users_view.class);
                    startActivity(intent);
                                    }
            });
    }
}