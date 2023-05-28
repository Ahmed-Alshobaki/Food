package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivitySignup2Binding;


import DataBase.DataBase_food;
import DataBase.user;


public class SIGNUP extends AppCompatActivity {
ActivitySignup2Binding binding;
DataBase_food dataBase_food =new DataBase_food(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySignup2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String  Name_SignUp =  binding.Name3.getText().toString();
                String  EDit_Email =  binding.EDitEmail.getText().toString().trim();
                String  EDit_Password =  binding.Password.getText().toString();
                String  EditText_Password2 =  binding.EditTextPassword2.getText().toString();
                if (Name_SignUp.isEmpty()){
                    binding.Name3.setError("Please enter your name");
                }else if (!(Name_SignUp.length()>=3)){  binding.Name3.setError("Enter a name of 3 or more characters");}

               if (!(isValidEmail(EDit_Email))){
                   binding.EDitEmail.setError("Please enter your Email");

                }
               if (EDit_Password.isEmpty()){
                   binding.Password.setError("Please enter your Password");
               }

               if (EditText_Password2.isEmpty()){
                   binding.EditTextPassword2.setError("Please enter your Password");
                }
                if (EDit_Password.length()>=6&&EditText_Password2.length()>=6){
                    if (EDit_Password.equals(EditText_Password2)&&isValidEmail(EDit_Email)&&!(Name_SignUp.isEmpty())){

                        user user  =new user(Name_SignUp,EDit_Email,EDit_Password);

                        if (dataBase_food.insertUser(user)){
                            Intent intent1 =new Intent(SIGNUP.this,singIN.class);
                        startActivity(intent1);
                        }

                        else {
                        AlertDialog.Builder builder =new AlertDialog.Builder(SIGNUP.this);
                        builder.setTitle("Wrong").setMessage("There is a problem with storage in databases!!");
                        builder.show();
                        }
                    }
                }else if (!EDit_Password.equals(EditText_Password2) ){
                    binding.Password.setError("One secret word is not equal to the other");
                    binding.EditTextPassword2.setError("One secret word is not equal to the other");
                }




            }
        });
        binding.SignupDonthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SIGNUP.this,singIN.class);
                startActivity(intent);
            }
        });


    }
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}