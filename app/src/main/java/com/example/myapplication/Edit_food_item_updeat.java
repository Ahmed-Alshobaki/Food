package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityEditFoodItemUpdeatBinding;

import java.io.IOException;

import DataBase.DataBase_food;
import DataBase.Food;


public class Edit_food_item_updeat extends AppCompatActivity {
ActivityEditFoodItemUpdeatBinding  binding;
DataBase_food dataBaseFood ;
    Bitmap bitmap ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditFoodItemUpdeatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBaseFood =new DataBase_food(getBaseContext());
        Intent intent =getIntent();
        binding.EnterTheNameOfTheMeal.setText(intent.getStringExtra("name"));
        binding.EnterTheNameOfIdAdd.setText(intent.getStringExtra("id"));
        binding.descriptionAdd.setText(intent.getStringExtra("Description"));
        binding.Qty.setText(intent.getStringExtra("Qty"));
        binding.EnterPrice.setText(intent.getStringExtra("Evaluate"));
        binding.EnterRateStars.setText(intent.getStringExtra("Rate"));
        ActivityResultLauncher<Intent> launcher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
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

        dataBaseFood=new DataBase_food(getBaseContext());
        binding.Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =getIntent();
//                Food food  =new Food();
//                food.setId(binding.EnterTheNameOfIdAdd.getText().toString());
//                food.setName(binding.EnterTheNameOfTheMeal.getText().toString());
//                food.setPrice(binding.EnterRateStars.getText().toString());
//                food.setQty( binding.Qty.getText().toString());
//                food.setDescription( binding.descriptionAdd.getText().toString());





//                String s = intent.getStringExtra("id");

//                Food food1 = checkupdet(s);



                String id = binding.EnterTheNameOfIdAdd.getText().toString();
                String qtyy = binding.Qty.getText().toString();
                String name = binding.EnterTheNameOfTheMeal.getText().toString();
                String des = binding.descriptionAdd.getText().toString();
                String price = binding.EnterPrice.getText().toString();
                String rate = binding.EnterRateStars.getText().toString();

                String type ="";
                if (binding.Burger.isChecked()){
                    type = "Burger";
                }if (binding.Pizza.isChecked()){
                    type="Pizza";
                }if (binding.Sandwich.isChecked()){
                    type="Sandwich";
                }


                if ( dataBaseFood.Updatefood(id,name,qtyy,des,price,rate,type,bitmap)){
                    Toast.makeText(Edit_food_item_updeat.this, "Done", Toast.LENGTH_SHORT).show();

                }else Toast.makeText(Edit_food_item_updeat.this, "fales", Toast.LENGTH_SHORT).show();

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
//    @SuppressLint("Range")
//    public Food checkupdet(String id ){
//        Cursor cursor = dataBaseFood.getCursorFood();
//        Food food_edit_item  =new Food();
//        while (cursor.moveToNext()){
//
//            if (cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_ID)).equals(id)){
//
//                food_edit_item.setName(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_NAME)));
//                food_edit_item.setDescription(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_DESCRIPTION)));
//                food_edit_item.setPrice(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_PRICE)));
//                food_edit_item.setRate(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_RATE)));
//                food_edit_item.setQty(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_Qty)));
//                food_edit_item.setId(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_FOOD_ID)));
//            }
//
//
//
//
//        }
//        return food_edit_item;
//    }



}