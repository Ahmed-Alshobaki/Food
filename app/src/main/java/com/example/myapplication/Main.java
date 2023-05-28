package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.databinding.MainBinding;

import java.util.ArrayList;
import java.util.List;

import DataBase.DataBase_food;
import adapter.adapterFood;
import adapter.recycleFood;


public class Main extends Fragment implements adapterFood.onclick {
MainBinding bindingg;

DataBase_food dataBase_food ;

    List<recycleFood> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        bindingg = MainBinding.inflate(inflater, container, false);
        View rootView = bindingg.getRoot();
        dataBase_food=new DataBase_food(getContext());

        int[] imageArray = { R.drawable.img, R.drawable.img_16,
                R.drawable.img_18,
               };

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                bindingg.imageTl.setScaleType(ImageView.ScaleType.FIT_XY);
                bindingg.imageTl.setImageResource(imageArray[i]);

                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }

                handler.postDelayed(this, 2500);

            }
        };
        handler.postDelayed(runnable, 2500);






//        bindingg.imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    FragmentTransaction fr = getFragmentManager().beginTransaction();
//                    fr.replace(R.id.FrameLayout,new Personal());
//                    fr.commit();
//                }
//
//        });
        list = new ArrayList<>();
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger1", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger2", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger3", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger4", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger5", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burger6", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.star, "2.5", R.drawable.burger, "Chese burge7r", "100 gr chicken + tomato+" +
                "                                    cheese  Lettuce", "20.00","$"));



        adapterFood adapterFood = new adapterFood(getContext(), list, new adapterFood.onclick() {
            @Override
            public void onitem(int position) {
                Intent intent=new Intent(getContext(),Details.class);
            }
        });
        bindingg.listRecyclerview.setAdapter(adapterFood);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);
       bindingg.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               add.selectProfile();
           }
       });
       bindingg.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Cursor cursor =dataBase_food.getCursor();
               Toast.makeText(getContext(), cursor.getCount()+"", Toast.LENGTH_SHORT).show();
           }
       });
        return rootView;
    }

    @Override
    public void onitem(int position) {
        bindingg.textView15.setText(list.get(position).getTitle());

    }








}