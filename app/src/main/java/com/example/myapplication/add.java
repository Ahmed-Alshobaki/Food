package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityAddBinding;

public class add extends AppCompatActivity {
ActivityAddBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacefragment(new Main());


        binding.bootm.setOnNavigationItemSelectedListener(item -> {

            if (item.getItemId()==R.id.bottom_home){
                replacefragment(new Main());
            } else if (item.getItemId()==R.id.favorites){
                replacefragment(new favoritess());

            }else if (item.getItemId()==R.id.cart){
              replacefragment(new Main());

            }else if (item.getItemId()==R.id.bottom_person){
            replacefragment(new Personal());

            }

            return true;
        });


    }

    private void replacefragment(Fragment f){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout,f);
        fragmentTransaction.commit();
    }

}