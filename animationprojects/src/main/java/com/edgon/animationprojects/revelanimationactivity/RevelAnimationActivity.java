package com.edgon.animationprojects.revelanimationactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edgon.animationprojects.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RevelAnimationActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.layout_reveal)
    LinearLayout layoutReveal;
    @BindView(R.id.btn_show)
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revel_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_show)
    public void onViewClicked() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void  startReveale(){


    }
}
