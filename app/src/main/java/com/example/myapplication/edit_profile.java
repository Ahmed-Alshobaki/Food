package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.myapplication.databinding.ActivityEditProfileBinding;

import java.io.IOException;

import DataBase.DataBase_food;
import DataBase.user;

public class edit_profile extends AppCompatActivity {
ActivityEditProfileBinding binding;
DataBase_food dataBase_food ;
    Bitmap bitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent =getIntent();
       String name = intent.getStringExtra("name");
       String email= intent.getStringExtra("email");
        String id= intent.getStringExtra("id");
       binding.editName.setText(name);
       binding.editEmail.setText(email);
        dataBase_food =new DataBase_food(getBaseContext());
       user user= dataBase_food.getUserById(1);
        binding.celebrityImage.setImageBitmap(user.getImag());
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Uri uri =result.getData().getData();
                try {

                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                binding.celebrityImage.setImageURI(uri);
            }
        });
        binding.celebrityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dataBase_food =new DataBase_food(getBaseContext());
               String name_input = binding.editName.getText().toString();
                String email_input = binding.editEmail.getText().toString();



                if (  binding.EditPassword1.getText().toString().equals(binding.EditTextPassword2.getText().toString())){
                    dataBase_food.updateUserById("1",name_input,email_input,bitmap, binding.EditPassword1.getText().toString());
                    finish();
                }


            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);

            }
        });



    }
}