package com.edgon.recyclerview_realm.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.edgon.recyclerview_realm.R;

public class DetailActivity extends AppCompatActivity {

    private TextView txtNameDetail;
    private TextView txtPhoneDetail;
    private TextView txtEmailDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtNameDetail = (TextView) findViewById(R.id.txt_name_detail);
        txtPhoneDetail = (TextView) findViewById(R.id.txt_phone_detail);
        txtEmailDetail = (TextView) findViewById(R.id.txt_email_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");
            String email = bundle.getString("email");

            txtNameDetail.setText(name);
            txtPhoneDetail.setText(phone);
            txtEmailDetail.setText(email);
        }
    }
}
