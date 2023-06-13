package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentCartBinding;
import com.example.myapplication.databinding.MainBinding;

import java.util.ArrayList;

import DataBase.DataBase_food;
import DataBase.Food;
import adapter.adapterFood_Edit_item;
import adapter.adapterFood_Edit_item_sell;
import adapter.adapterFood_veiw_users;


public class cart extends Fragment {
    FragmentCartBinding binding;

    DataBase_food dataBase_food;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        dataBase_food=new DataBase_food(getContext());
         adapterFood_Edit_item_sell    itemSell =new adapterFood_Edit_item_sell(getContext(), dataBase_food.SearchFood_sell(), new adapterFood_Edit_item_sell.onclick() {
             @Override
             public void onitem(int position) {

             }
         });
         binding.recyclerview.setAdapter(itemSell);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

         binding.recyclerview.setLayoutManager(linearLayoutManager);
         binding.titalNumber.setText(dataBase_food.sumPriceWhenSellTrue()+"");
         binding.itemsNumber.setText(dataBase_food.countItemsWhenSellTrue()+"");










       return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.titalNumber.setText(dataBase_food.sumPriceWhenSellTrue()+"");
        binding.itemsNumber.setText(dataBase_food.countItemsWhenSellTrue()+"");
    }
}