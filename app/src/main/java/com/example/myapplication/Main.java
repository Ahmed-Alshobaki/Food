package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.text.InputType;
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



public class Main extends Fragment implements adapterFood.onclick {
    MainBinding bindingg;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


DataBase_food dataBase_food ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        preferences=getContext().getSharedPreferences("MyPerfe", Context.MODE_PRIVATE);
        editor=preferences.edit();


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




    bindingg.editText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(),SearchActivity.class);
            startActivity(intent);
            bindingg.editText.setKeyListener(null);
        }
    });



        adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.getDoodList(), new adapterFood.onclick() {
            @Override
            public void onitem(int position) {
                Intent intent=new Intent(getContext(),Details.class);
                intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                intent.putExtra("type",dataBase_food.getDoodList().get(position).getType());
                if (dataBase_food.getDoodList().get(position).getType()==null){
                    intent.putExtra("Like","false");
                }else {                intent.putExtra("Like",dataBase_food.getDoodList().get(position).getLike());
                }
                startActivity(intent);
            }

            @Override
            public void onitemlike(int position) {

            }
        });
        bindingg.listRecyclerview.setAdapter(adapterFood_Pizza);
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

       bindingg.BurgerId.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               bindingg.BurgerId.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
               bindingg.BurgerId.setTextColor(Color.WHITE);
               bindingg.PizzaId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.PizzaId.setTextColor(Color.BLACK);
               bindingg.SandwichId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.SandwichId.setTextColor(Color.BLACK);
               bindingg.all.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.all.setTextColor(Color.BLACK);
               adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.SearchFood_type_Burger(), new adapterFood.onclick() {
                   @Override
                   public void onitem(int position) {
                       Intent intent=new Intent(getContext(),Details.class);
                       intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                       intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                       intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                       intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                       intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                       intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                       intent.putExtra("type",dataBase_food.getDoodList().get(position).getType());
                       intent.putExtra("Like",dataBase_food.getDoodList().get(position).getLike());
                       startActivity(intent);
                   }

                   @Override
                   public void onitemlike(int position) {

                   }
               });
               bindingg.listRecyclerview.setAdapter(adapterFood_Pizza);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
               bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);


           }
       });
       bindingg.all.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               bindingg.BurgerId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.BurgerId.setTextColor(Color.BLACK);
               bindingg.PizzaId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.PizzaId.setTextColor(Color.BLACK);
               bindingg.SandwichId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.SandwichId.setTextColor(Color.BLACK);
               bindingg.all.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
               bindingg.all.setTextColor(Color.WHITE);
               adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.getDoodList(), new adapterFood.onclick() {
                   @Override
                   public void onitem(int position) {
                       Intent intent=new Intent(getContext(),Details.class);
                       intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                       intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                       intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                       intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                       intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                       intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                       intent.putExtra("type",dataBase_food.getDoodList().get(position).getType());
                       intent.putExtra("Like",dataBase_food.getDoodList().get(position).getLike());
                       startActivity(intent);
                   }

                   @Override
                   public void onitemlike(int position) {

                   }
               });
               bindingg.listRecyclerview.setAdapter(adapterFood_Pizza);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
               bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);
           }
       });
       bindingg.PizzaId.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

              bindingg.BurgerId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.BurgerId.setTextColor(Color.BLACK);
               bindingg.PizzaId.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
               bindingg.PizzaId.setTextColor(Color.WHITE);
               bindingg.SandwichId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.SandwichId.setTextColor(Color.BLACK);
               bindingg.all.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.all.setTextColor(Color.BLACK);
               adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.SearchFood_type_Pizza(), new adapterFood.onclick() {
                   @Override
                   public void onitem(int position) {
                       Intent intent=new Intent(getContext(),Details.class);
                       intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                       intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                       intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                       intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                       intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                       intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                       intent.putExtra("type",dataBase_food.getDoodList().get(position).getType());
                       intent.putExtra("Like",dataBase_food.getDoodList().get(position).getLike());

                       startActivity(intent);
                   }

                   @Override
                   public void onitemlike(int position) {

                   }
               });
               bindingg.listRecyclerview.setAdapter(adapterFood_Pizza);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
               bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);


           }
       });
       bindingg.SandwichId.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               bindingg.BurgerId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.BurgerId.setTextColor(Color.BLACK);
               bindingg.PizzaId.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.PizzaId.setTextColor(Color.BLACK);
               bindingg.SandwichId.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
               bindingg.SandwichId.setTextColor(Color.WHITE);
               bindingg.all.setBackground(getContext().getResources().getDrawable(R.drawable.shep_22));
               bindingg.all.setTextColor(Color.BLACK);
               adapterFood adapterFood_Pizza = new adapterFood(getContext(), dataBase_food.SearchFood_type_Sandwich(), new adapterFood.onclick() {
                   @Override
                   public void onitem(int position) {
                       Intent intent=new Intent(getContext(),Details.class);
                       intent.putExtra("name",dataBase_food.getDoodList().get(position).getName());
                       intent.putExtra("Id",dataBase_food.getDoodList().get(position).getId());
                       intent.putExtra("Qty",dataBase_food.getDoodList().get(position).getQty());
                       intent.putExtra("Description",dataBase_food.getDoodList().get(position).getDescription());
                       intent.putExtra("Rate",dataBase_food.getDoodList().get(position).getRate());
                       intent.putExtra("Price",dataBase_food.getDoodList().get(position).getPrice());
                       intent.putExtra("type",dataBase_food.getDoodList().get(position).getType());
                       intent.putExtra("Like",dataBase_food.getDoodList().get(position).getLike());

                       startActivity(intent);
                   }

                   @Override
                   public void onitemlike(int position) {

                   }


               });
               bindingg.listRecyclerview.setAdapter(adapterFood_Pizza);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
               bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);
           }
       });
        return rootView;
    }

    @Override
    public void onitem(int position) {
        bindingg.textView15.setText(dataBase_food.getDoodList().get(position).getId());

    }

    @Override
    public void onitemlike(int position) {

    }


}