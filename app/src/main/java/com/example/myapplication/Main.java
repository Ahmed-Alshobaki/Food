package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.myapplication.databinding.MainBinding;

import java.util.ArrayList;
import java.util.List;

import adapter.adapterFood;
import adapter.recycleFood;


public class Main extends Fragment {
MainBinding bindingg;

    List<recycleFood> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        bindingg = MainBinding.inflate(inflater, container, false);
        View rootView = bindingg.getRoot();
        list = new ArrayList<>();
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));
        list.add(new recycleFood(R.drawable.img22, "2.5", R.drawable.burger, "Chese burger", "100 gr chicken + tomato+\n" +
                "                                    cheese  Lettuce", "20.00","$"));



        adapterFood adapterFood = new adapterFood(getContext(), list);
        bindingg.listRecyclerview.setAdapter(adapterFood);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        bindingg.listRecyclerview.setLayoutManager(linearLayoutManager);

        return rootView;
    }
}