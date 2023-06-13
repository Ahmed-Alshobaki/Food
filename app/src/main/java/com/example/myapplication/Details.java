package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.DetailsBinding;

import DataBase.DataBase_food;
import DataBase.Food;


public class Details extends AppCompatActivity {
DetailsBinding binding;
double Qty =1 ;
    double titalPrice;
    DataBase_food dataBaseFood;
    double a2;
    int increase=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =DetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBaseFood =new DataBase_food(getBaseContext());
        Intent intent =getIntent();
        String name =intent.getStringExtra("name");

        intent.getStringExtra("Description");


        double Qty_dataBase=Double.parseDouble(intent.getStringExtra("Qty"));
        binding.textView11.setText(name);
        binding.textView12.setText(   intent.getStringExtra("Description"));
        binding.textView3.setText( intent.getStringExtra("Rate"));
        binding.textView14.setText(  intent.getStringExtra("Price"));
        String s =intent.getStringExtra("Like");


           String s1 = intent.getStringExtra("Id");
                Food food =   dataBaseFood.getFoodById(s1);
                if (food.getLike().equals("true")){
                    binding.MyFavorite.setImageResource(R.drawable.bookmark);
                }else {}


        binding.imageView8.setImageBitmap(dataBaseFood.getbyteBitmap(dataBaseFood.getImageById(s1)));

        double a1 = Double.parseDouble(binding.textView14.getText().toString());
        a2=a1;
        binding.imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Qty>=0&&(Qty_dataBase>Qty)){
                    Qty++;
                }if (Qty==Qty_dataBase){
                    Toast.makeText(Details.this, "Highest number of people to reach "+Qty, Toast.LENGTH_SHORT).show();
                }

                binding.textView13.setText(String.valueOf(Qty));
                titalPrice=a2*Qty;
                binding.textView14.setText(String.valueOf(titalPrice));

                if (binding.textView14.length() > 5) {
                    String truncatedText = binding.textView14.getText().toString().substring(0, 5);
                    binding.textView14.setText(String.valueOf(truncatedText));
                }


            }
        });
        binding.MyFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increase++;
                    if (increase%2==1){
                        dataBaseFood.updateFoodLike(  intent.getStringExtra("Id"),"true");
                    binding.MyFavorite.setImageResource(R.drawable.bookmark);


                    }
                    if (increase%2==0) {
                        dataBaseFood.updateFoodLike(  intent.getStringExtra("Id"),"false");
                        binding.MyFavorite.setImageResource(R.drawable.book2);};

                }
            });
        binding.imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Qty>0)){
                    Qty--;
                }
                binding.textView13.setText(String.valueOf(Qty));
                titalPrice=a2*Qty;
                binding.textView14.setText(String.valueOf(titalPrice));
                if (binding.textView14.length() > 5) {
                    String truncatedText = binding.textView14.getText().toString().substring(0, 5);
                    binding.textView14.setText(String.valueOf(truncatedText));

                }

            }
        });
        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseFood =new DataBase_food(Details.this);
                dataBaseFood.updateFoodSell( intent.getStringExtra("Id"),"true");
            Intent intent1  =new Intent(Details.this,add.class);
                intent1.putExtra("add",1);
            startActivity(intent1);

            }
        });



    }
}