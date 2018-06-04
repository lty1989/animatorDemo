package com.lty.animator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SlideActivity extends BaseActivity {


    @BindView(R.id.container)
    ViewGroup container;

    @BindView(R.id.leftView)
    View leftView;

    boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_form_left);
        leftView.startAnimation(animation);
        isShow = true;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_slide;
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, SlideActivity.class);
        ctx.startActivity(intent);
    }

    @OnClick(R.id.container)
    public void hide() {

        if (isShow) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_to_left);
            animation.setFillAfter(true);
            leftView.startAnimation(animation);
            isShow = false;
        } else {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_form_left);
            leftView.startAnimation(animation);
            isShow = true;

        }
    }

}
