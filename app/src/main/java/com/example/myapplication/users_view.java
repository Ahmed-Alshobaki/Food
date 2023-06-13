package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityUsersViewBinding;

import java.util.ArrayList;
import java.util.List;

import DataBase.DataBase_food;
import DataBase.user;
import adapter.adapterFood_veiw_users;

public class users_view extends AppCompatActivity {
ActivityUsersViewBinding binding;
    adapterFood_veiw_users  adapterFood_veiw_users;
  List<user> list;
  DataBase_food dataBaseFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityUsersViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list =new ArrayList<>();
        dataBaseFood = new DataBase_food(getBaseContext());
          adapterFood_veiw_users  adapterFood_veiw_users1 =new adapterFood_veiw_users(getApplication(),dataBaseFood.getDooduser());
        binding.RecyclerView.setAdapter(adapterFood_veiw_users1);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(users_view.this, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,false);
        binding.RecyclerView.setLayoutManager(LinearLayoutManager);
        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(users_view.this,Control_Panel.class);
                startActivity(intent);
            }
        });
    }
}