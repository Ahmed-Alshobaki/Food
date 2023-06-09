package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityAddBinding;

import DataBase.DataBase_food;
import DataBase.user;

public class add extends AppCompatActivity {

static ActivityAddBinding binding ;
DataBase_food dataBase_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent =getIntent();
        if (intent.getIntExtra("add",-1)==1){
            replacefragment(new cart());
            binding.bootm.setSelectedItemId(R.id.cart);
        }else {   replacefragment(new Main());}
        dataBase_food=new DataBase_food(getBaseContext());











        binding.bootm.setOnNavigationItemSelectedListener(item -> {

            if (item.getItemId()==R.id.bottom_home){

                replacefragment(new Main());


            } else if (item.getItemId()==R.id.favorites){
                replacefragment(new favoritess());

            }else if (item.getItemId()==R.id.cart){
              replacefragment(new cart());

            }else if (item.getItemId()==R.id.bottom_person){
            replacefragment(new personaal());

            }

            return true;
        });





    }


    public static void selectProfile(){
        binding.bootm.setSelectedItemId(R.id.bottom_person);

    }
    public void selectcart(){

        binding.bootm.setSelectedItemId(R.id.cart);

    }

    public static void selectbackmine(){
        binding.bootm.setSelectedItemId(R.id.bottom_home);

    }

    private void replacefragment(Fragment f){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.FrameLayout,f);
        fragmentTransaction.commit();
    }

}