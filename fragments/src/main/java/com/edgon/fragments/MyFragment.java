package com.edgon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyFragment extends Fragment {

    private TextView tvTitle;
    private String title;


    public MyFragment() {
        // Required empty public constructor
    }

    public MyFragment(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        // Inflate the layout for this fragment

        tvTitle = (TextView) view.findViewById(R.id.txt_frag);
        tvTitle.setText(title);

        return view;
    }





}
