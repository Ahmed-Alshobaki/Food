package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.myapplication.databinding.ActivityEditAdminFoodItemBinding;

import java.util.List;

import DataBase.DataBase_food;
import DataBase.Food;
import adapter.Food_Edit_item;
import adapter.adapterFood_Edit_item_Admin;

public class edit_admin_food_item extends AppCompatActivity {
    ActivityEditAdminFoodItemBinding binding ;
    List<Food>list ;
    DataBase_food dataBase_food ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityEditAdminFoodItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBase_food =new DataBase_food(getBaseContext());
        adapterFood_Edit_item_Admin adapterFood_edit_item_admin = new adapterFood_Edit_item_Admin(getBaseContext(), dataBase_food.getDoodList_Edit(), new adapterFood_Edit_item_Admin.onclick() {
            @Override
            public void onitem(int position) {
                Intent intent = new Intent(edit_admin_food_item.this,Edit_food_item_updeat.class);
                intent.putExtra("name",dataBase_food.getDoodList_Edit().get(position).getName());
                intent.putExtra("id",dataBase_food.getDoodList_Edit().get(position).getId());
                intent.putExtra("Description",dataBase_food.getDoodList_Edit().get(position).getDescription());
                intent.putExtra("Qty",dataBase_food.getDoodList_Edit().get(position).getQty());
                intent.putExtra("Evaluate",dataBase_food.getDoodList_Edit().get(position).getPrice());
                intent.putExtra("Rate",dataBase_food.getDoodList_Edit().get(position).getRate());
                intent.putExtra("type",dataBase_food.getDoodList_Edit().get(position).getType());

                startActivity(intent);

            }
        }){};
        binding.REditFood.setAdapter(adapterFood_edit_item_admin);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        binding.REditFood.setLayoutManager(gridLayoutManager);
        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(edit_admin_food_item.this,Control_Panel.class);
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterFood_Edit_item_Admin adapterFood_edit_item_admin = new adapterFood_Edit_item_Admin(getBaseContext(), dataBase_food.getDoodList_Edit(), new adapterFood_Edit_item_Admin.onclick() {
            @Override
            public void onitem(int position) {
                Intent intent = new Intent(edit_admin_food_item.this,Edit_food_item_updeat.class);
                intent.putExtra("name",dataBase_food.getDoodList_Edit().get(position).getName());
                intent.putExtra("id",dataBase_food.getDoodList_Edit().get(position).getId());
                intent.putExtra("Description",dataBase_food.getDoodList_Edit().get(position).getDescription());
                intent.putExtra("Qty",dataBase_food.getDoodList_Edit().get(position).getQty());
                intent.putExtra("Evaluate",dataBase_food.getDoodList_Edit().get(position).getPrice());
                intent.putExtra("Rate",dataBase_food.getDoodList_Edit().get(position).getRate());

                startActivity(intent);

            }
        }){};
        binding.REditFood.setAdapter(adapterFood_edit_item_admin);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        binding.REditFood.setLayoutManager(gridLayoutManager);
    }
}