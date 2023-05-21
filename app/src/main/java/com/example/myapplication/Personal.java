package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myapplication.databinding.PersonalBinding;

public class Personal extends Fragment {

PersonalBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding=PersonalBinding.inflate(inflater, container, false);
      View v=  binding.getRoot();
      return v;
    }
}