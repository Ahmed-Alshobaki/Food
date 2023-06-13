package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.example.myapplication.databinding.ActivityAddNewProductsBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import DataBase.DataBase_food;
import DataBase.Food;

public class Add_new_products extends AppCompatActivity {

    DataBase_food dataBase_food;
    Food food =new Food();
    ActivityAddNewProductsBinding binding;
    Bitmap bitmap ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNewProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActivityResultLauncher<Intent>launcher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
             Uri uri=  result.getData().getData();
             binding.imageView13.setImageURI(uri);
                try {

                 bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });






        binding.Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 dataBase_food=new DataBase_food(Add_new_products.this);



                String Name=binding.EnterTheNameOfTheMeal.getText().toString();
                String Price=binding.EnterPrice.getText().toString();
                String Id=binding.EnterTheNameOfIdAdd.getText().toString();
                String Descript=binding.descriptionAdd.getText().toString();
                String Rate=binding.EnterRateStars.getText().toString();
                String Qty = binding.Qty.getText().toString();



                String type ="";
                if (binding.Burger.isChecked()){
                    type = "Burger";
                }if (binding.Pizza.isChecked()){
                    type="Pizza";
                }if (binding.Sandwich.isChecked()){
                    type="Sandwich";
                }




                food=new Food(Name,Id,Descript,Price,Rate,Qty,type,bitmap);

                if (dataBase_food.insertFood(food)) {
                    Toast.makeText(Add_new_products.this, "Done", Toast.LENGTH_SHORT).show();

                }
                binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(Add_new_products.this,Control_Panel.class);
                        startActivity(intent);
                    }
                });







            }
        });
        binding.idAddImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);
            }
        }); binding.imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);
            }
        });








    }

}