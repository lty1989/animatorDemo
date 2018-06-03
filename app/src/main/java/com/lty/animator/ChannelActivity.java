package com.lty.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChannelActivity extends BaseActivity {

    @BindView(R.id.view1)
    RecyclerView view1;

    @BindView(R.id.view2)
    RecyclerView view2;

    @BindView(R.id.view3)
    RecyclerView view3;

    @BindView(R.id.arrow)
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("abc" + i);
        }

        view1.setAdapter(new ChannelAdapter(data));
        view2.setAdapter(new ChannelAdapter(data));
        view3.setAdapter(new ChannelAdapter(data));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_channel;
    }


    boolean isShowView1 = false;
    boolean isShowView3 = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AnimatorSet animatorSet = new AnimatorSet();
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:

                if (isShowView3) {
                    ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", -260f, 0f);
                    ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", -260f, 0f);
                    ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", -260f, 0f);
                    ObjectAnimator animatorView4 = ObjectAnimator.ofFloat(view3, "alpha", 1.0f, 0.0f);
                    animatorSet.playTogether(animatorView1, animatorView2, animatorView3, animatorView4);
                    animatorSet.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            arrow.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            view3.setVisibility(View.GONE);
                        }
                    });
                    animatorSet.setDuration(600);
                    animatorSet.start();

                    isShowView3 = false;
                    return true;
                }

                if (!isShowView1) {
                    ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", -820f, 0f);
                    ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", -820f, 0f);
                    ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", -820f, 0f);
                    animatorSet.playTogether(animatorView1, animatorView2, animatorView3);
                    animatorSet.setDuration(600);
                    animatorSet.start();
                    isShowView1 = true;
                }

                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (isShowView1 || !isShowView3) {
                    ObjectAnimator animatorViewR1 = ObjectAnimator.ofFloat(view1, "translationX", 0f, -260f);
                    ObjectAnimator animatorViewR2 = ObjectAnimator.ofFloat(view2, "translationX", 0f, -260f);
                    ObjectAnimator animatorViewR3 = ObjectAnimator.ofFloat(view3, "translationX", 0f, -260f);
                    ObjectAnimator animatorViewR4 = ObjectAnimator.ofFloat(view3, "alpha", 0.0f, 1.0f);
                    ObjectAnimator animatorViewR5 = ObjectAnimator.ofFloat(arrow, "translationX", 0f, -260f);
                    ObjectAnimator animatorViewR6 = ObjectAnimator.ofFloat(arrow, "alpha", 0.0f, 1.0f);

                    animatorSet.playTogether(animatorViewR1, animatorViewR2, animatorViewR3, animatorViewR4, animatorViewR5, animatorViewR6);
                    animatorSet.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            view3.setVisibility(View.VISIBLE);
                            view3.setAlpha(0.0f);

                            arrow.setVisibility(View.VISIBLE);
                            arrow.setAlpha(0.0f);
                        }
                    });
                    animatorSet.setDuration(600);
                    animatorSet.start();
                    isShowView1 = false;
                    isShowView3 = true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, ChannelActivity.class);
        ctx.startActivity(intent);
    }
}
