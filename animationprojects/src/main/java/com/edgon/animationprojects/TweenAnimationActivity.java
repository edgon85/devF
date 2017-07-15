package com.edgon.animationprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tween_animation_1)
    TextView txtAnimation1;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.btn_rotar)
    Button btnRotar;
    @BindView(R.id.btn_fade)
    Button btnFade;
    @BindView(R.id.btn_blink)
    Button btnBlink;
    @BindView(R.id.btn_move)
    Button btnMove;
    @BindView(R.id.btn_slide)
    Button btnSlide;
    @BindView(R.id.btn_new_animation)
    Button btnNewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tween_animation_1)
    public void hacerAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_tween);
        txtAnimation1.startAnimation(animation);
    }

    @OnClick(R.id.button)
    public void Clockwise(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_rotar)
    public void onViewClicked() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_fade)
    public void fade() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_blink)
    public void blink() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blinkanimation);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_move)
    public void move() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moveanimation);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_slide)
    public void slide() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideanimation);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.btn_new_animation)
    public void newAnimation() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.newanimation);
        imageView.startAnimation(animation);
    }
}
