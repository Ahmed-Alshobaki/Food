package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.myapplication.databinding.ActivitySearchBinding;

import DataBase.DataBase_food;
import adapter.adapterFood;

public class SearchActivity extends AppCompatActivity {


    ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DataBase_food dataBase_food=new DataBase_food(SearchActivity.this);



        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapterFood adapterFood = new adapterFood(SearchActivity.this, dataBase_food.SearchFood(binding.editText.getText().toString()), new adapterFood.onclick() {
                    @Override
                    public void onitem(int position) {
                        Intent intent=new Intent(SearchActivity.this,Details.class);
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
                binding.recycleSearch.setAdapter(adapterFood);
                GridLayoutManager  gridLayoutManager =new GridLayoutManager(SearchActivity.this,2);

                binding.recycleSearch.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });












    }
}