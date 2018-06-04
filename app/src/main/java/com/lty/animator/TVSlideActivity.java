package com.lty.animator;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import butterknife.BindView;

public class TVSlideActivity extends BaseActivity {


    @BindView(R.id.slideLl)
    View slideLl;

    @BindView(R.id.view1)
    View view1;

    @BindView(R.id.view2)
    View view2;

    @BindView(R.id.view3)
    View view3;

    @BindView(R.id.view4)
    View view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tvslide;
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, TVSlideActivity.class);
        ctx.startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                AnimatorSet animatorSet1 = new AnimatorSet();

                ObjectAnimator oa1 = ObjectAnimator.ofFloat(slideLl, "translationX", 0f, -300f);
                ObjectAnimator ooa1a = ObjectAnimator.ofFloat(view4, "translationX", 0f, 530f);
                // ObjectAnimator ooa1a = ObjectAnimator.ofFloat(view4, "translationX", -600, 0f);

                animatorSet1.playTogether(oa1, ooa1a);


                animatorSet1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        view4.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view2.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animatorSet1.setDuration(500);
                animatorSet1.start();

                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ooa2a = ObjectAnimator.ofFloat(slideLl, "translationX", -300f, 0f);
                ObjectAnimator ooa2as = ObjectAnimator.ofFloat(view4, "translationX", 530f, 0f);
                animatorSet.playTogether(ooa2a, ooa2as);
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        view2.setVisibility(View.GONE);
                        // view4.setVisibility(View.GONE);


                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animatorSet.setDuration(500);
                animatorSet.start();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
