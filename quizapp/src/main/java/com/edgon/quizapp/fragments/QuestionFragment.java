package com.edgon.quizapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.edgon.quizapp.R;


public class QuestionFragment extends Fragment implements View.OnClickListener {

    private TextView txtTitle;
    private Button btnTrue;
    private Button btnFalse;
    private String question;
    private int respuesta = 0;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public QuestionFragment(String question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        initView(view);

        return view;
    }

    void initView(View v) {
        txtTitle = (TextView) v.findViewById(R.id.txt_title);
        btnTrue = (Button) v.findViewById(R.id.btn_true);
        btnFalse = (Button) v.findViewById(R.id.btn_false);

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);

        txtTitle.setText(question);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_true:
                btnTrue.setBackgroundResource(R.color.colorTrue);
                btnFalse.setBackgroundResource(R.color.colorButonPricipal);
                respuesta = 1;
              //  Log.d("MyLog :","true"+respuesta);
                break;
            case R.id.btn_false:
                btnFalse.setBackgroundResource(R.color.colorFalse);
                btnTrue.setBackgroundResource(R.color.colorButonPricipal);
                respuesta = 0;
              //  Log.d("MyLog :","false"+respuesta);
                break;
        }
    }

    public int getRespuesta() {
        return respuesta;
    }
}
