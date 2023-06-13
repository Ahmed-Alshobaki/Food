package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivitySignup2Binding;
import com.example.myapplication.databinding.ActivitySingInBinding;

import java.util.ArrayList;

import DataBase.DataBase_food;
import DataBase.user;

public class singIN extends AppCompatActivity {
 ActivitySingInBinding binding;

    SharedPreferences preferences;
    SharedPreferences preferencesE_p;
    public static String p;
 public static    String E;




    public DataBase_food dataBase_food =new DataBase_food(this);
    ArrayList<user>list =new ArrayList<user>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySingInBinding.inflate(getLayoutInflater());

            preferences =getSharedPreferences("login",MODE_PRIVATE);

           if ( preferences.getBoolean("savedName",false)){
                startActivity(new Intent(singIN.this,add.class));
           }


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
                        String p = Password;
                        String E = EmailEditText;


                        Toast.makeText(singIN.this, "sssssss"+checkLogin(EmailEditText,Password), Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(singIN.this, add.class);
                        intent.putExtra("email",binding.EmailEditText.getText().toString());
                        intent.putExtra("p",binding.Password.getText().toString());
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
               finish();


            }
        });
    }
    @SuppressLint("Range")
    public boolean checkLogin(String Email , String Password){
        // جلب حميع المعلومات ووضعها في واجهه
     // list =new ArrayList<>();
        Cursor cursor = dataBase_food.getCursor();




        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor  edit =preferences.edit();
                edit.putBoolean("savedName",isChecked);

                edit.apply();




            }
        });


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