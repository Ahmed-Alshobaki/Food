package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentPersonaalBinding;



public class personaal extends Fragment {

FragmentPersonaalBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentPersonaalBinding.inflate(inflater, container, false);
        View v=  binding.getRoot();
        
//        binding.LogoutP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(getContext(),add.class);
//                startActivity(intent);
//            }
//        });

//        binding.imageView5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                add.selectbackmine();
//            }
//        });

        return v;
    }
}