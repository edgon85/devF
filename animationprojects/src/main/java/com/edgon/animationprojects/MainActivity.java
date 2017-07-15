package com.edgon.animationprojects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edgon.animationprojects.revelanimationactivity.RevelAnimationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_animation_1)
    Button btnAnimation1;
    @BindView(R.id.btn_animation_2)
    Button btnAnimation2;
    @BindView(R.id.btn_animation_3)
    Button btnAnimation3;
    @BindView(R.id.btn_animation_4)
    Button btnAnimation4;
    @BindView(R.id.btn_animation_5)
    Button btnAnimation5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_animation_1, R.id.btn_animation_2, R.id.btn_animation_3, R.id.btn_animation_4, R.id.btn_animation_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_animation_1:
                startActivity(new Intent(MainActivity.this,TweenAnimationActivity.class));
                break;
            case R.id.btn_animation_2:
                startActivity(new Intent(MainActivity.this, RevelAnimationActivity.class));
                break;
            case R.id.btn_animation_3:
                break;
            case R.id.btn_animation_4:
                break;
            case R.id.btn_animation_5:
                break;
        }
    }
}
