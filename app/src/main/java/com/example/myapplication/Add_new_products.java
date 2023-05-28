package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityAddNewProductsBinding;

import DataBase.DataBase_food;

public class Add_new_products extends AppCompatActivity {


    ActivityAddNewProductsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNewProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






        binding.LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBase_food dataBase_food=new DataBase_food(Add_new_products.this);
                Food food =new Food();


                String Name=binding.EnterTheNameOfIdAdd.getText().toString();
                String Price=binding.EnterTheNameOfIdAdd.getText().toString();
                String Id=binding.EnterTheNameOfIdAdd.getText().toString();
                String Descript=binding.EnterTheNameOfIdAdd.getText().toString();
                String Rate=binding.EnterTheNameOfIdAdd.getText().toString();




                food=new Food(Name,Descript,Price,Rate,Id);


                if (dataBase_food.insertFood(food)) {

                    Toast.makeText(Add_new_products.this, "ADDED", Toast.LENGTH_SHORT).show();
                }







            }
        });







    }
}