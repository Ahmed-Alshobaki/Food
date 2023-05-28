package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivitySignup2Binding;
import com.example.myapplication.databinding.ActivitySingInBinding;

import java.util.ArrayList;

import DataBase.DataBase_food;
import DataBase.user;

public class singIN extends AppCompatActivity {
ActivitySingInBinding binding;
    public DataBase_food dataBase_food =new DataBase_food(this);
    ArrayList<user>list =new ArrayList<user>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySingInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String EmailEditText= binding.EmailEditText.getText().toString();
                String Password= binding.Password.getText().toString();
                if (EmailEditText.isEmpty()){
                    binding.EmailEditText.setError("Please enter an email");
                }if (Password.isEmpty()){
                    binding.Password.setError("Please enter an Password");
                }

                if (binding.EmailEditText.getText().toString().equals("a")&&binding.Password.getText().toString().equals("a")){
                    Intent intent=new Intent(singIN.this,Control_Panel.class);
                    startActivity(intent);
                }else {
                    if (checkLogin(EmailEditText,Password)){

                        Toast.makeText(singIN.this, "sssssss"+checkLogin(EmailEditText,Password), Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(singIN.this, add.class);
                        startActivity(intent);



                    }else {
                        AlertDialog.Builder builder =new AlertDialog.Builder(singIN.this);
                        builder.setTitle("Wrong").setMessage("There is a problem ");
                        builder.show();

                    }
                }


            }
        });
        binding.SignupDonthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(singIN.this,SIGNUP.class);
                startActivity(intent);

            }
        });
    }
    @SuppressLint("Range")
    public boolean checkLogin(String Email , String Password){
        // جلب حميع المعلومات ووضعها في واجهه
     // list =new ArrayList<>();
        Cursor cursor = dataBase_food.getCursor();







        while (cursor.moveToNext()){
       //     user user =new user(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_name)),
                 //   cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Email)), cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Password)));
         //   list.add(user);

                if (cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Email)).equals(Email)){
                    if (cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Password)).equals(Password)){
                        return true;
                    }
                }




        }
        return false;
    };
    @SuppressLint("Range")
    public user getUser(String Email , String Password){

        Cursor cursor = dataBase_food.getCursor();
            user user =new user();
        while (cursor.moveToNext()){

            if (cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Email)).equals(Email)){
                if (cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Password)).equals(Password)){
                    user.setName(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Email)));
                    user.setPassword(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Password)));
                    user.setName(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_name)));
                    user.setName(cursor.getString(cursor.getColumnIndex(DataBase_food.COLUMN_Id)));
                }
            }

        }
        return user;
    };
}