package com.lty.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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


    boolean isEmpty = true;

    public String[] COLLECT = {"我的收藏", "全部", "标清", "央视", "卫视", "本地", "吉视专享", "广播"};

    public String[] QUANBU = {"CCTV-1综合高清",
            "CCTV-2财经高清",
            "吉视卫视高清",
            "吉视都市",
            "长客电视",
            "北京卡酷",
            "CCTV-7军事农业高清",
            "影视频道",
            "安徽卫视高清",
            "广东卫视高清"};
    public String[] BIAOQING = {"CCTV-1综合",
            "CCTV-2财经",
            "CCTV-3综艺",
            "CCTV-5体育",
            "CCTV-6电影",
            "CCTV-7军事农业",
            "CCTV-8电视剧",
            "CCTV-9纪录",
            "CCTV-10科教",
            "CCTV-12社会与法",
            "CCTV-14少儿",
            "央广购物",
            "中视购物",
            "风尚购物",
            "家家购物",
            "好享购物",
            "时尚购物",
            "优购物",
            "环球购物"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_channel;
    }


    boolean isShowView1 = false;
    boolean isShowView3 = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AnimatorSet animatorSet = new AnimatorSet();
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:

                if (isShowView3) {
                    view3.setAdapter(null);

                    ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", -260f, 0f);
                    ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", -260f, 0f);
                    ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", -260f, 0f);
                    ObjectAnimator animatorView4 = ObjectAnimator.ofFloat(view3, "alpha", 1.0f, 0.0f);
                    ValueAnimator animatorRGBR5 = ValueAnimator.ofInt(0xcc363a4b, 0xcc3A3E4D, 0xcc3E424F, 0xcc434552, 0xcc474954, 0xcc464b56);
                    animatorRGBR5.setEvaluator(new ArgbEvaluator());
                    animatorRGBR5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int color = (int) animation.getAnimatedValue();
                            view1.setBackgroundColor(color);
                        }
                    });
                    ValueAnimator animatorRGBR6 = ValueAnimator.ofInt(0xcc464b56, 0xcc56575E, 0xcc606167, 0xcc6B6C6F, 0xcc757678, 0x7F808080);
                    animatorRGBR6.setEvaluator(new ArgbEvaluator());
                    animatorRGBR6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int color = (int) animation.getAnimatedValue();
                            view2.setBackgroundColor(color);
                        }
                    });
                    animatorSet.playTogether(animatorView1, animatorView2, animatorView3, animatorView4, animatorRGBR5, animatorRGBR6);
                    animatorSet.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
//                            view1.setBackgroundColor(Color.parseColor("#cc464b56"));
//                            view2.setBackgroundColor(Color.parseColor("#7f808080"));


                            arrow.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            view3.setVisibility(View.GONE);
                        }
                    });
                    animatorSet.setDuration(200);
                    animatorSet.start();

                    isShowView3 = false;
                    return true;
                }

                if (!isShowView1) {
                    ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", -820f, 0f);
                    ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", -820f, 0f);
                    ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", -820f, 0f);
                    animatorSet.playTogether(animatorView1, animatorView2, animatorView3);
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            List<String> data1 = new ArrayList<>();
                            for (int i = 0; i < COLLECT.length; i++) {
                                data1.add(COLLECT[i]);
                            }
                            LayoutAnimationController animation11 = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_animation_slide_left_view1);
                            view1.setLayoutAnimation(animation11);
                            view1.setAdapter(new ChannelAdapter(data1));

                            List<String> data2 = new ArrayList<>();
                            for (int i = 0; i < QUANBU.length; i++) {
                                data2.add(QUANBU[i]);
                            }
                            LayoutAnimationController animation12 = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_animation_slide_left_view2);
                            view2.setLayoutAnimation(animation12);
                            view2.setAdapter(new ChannelAdapter(data2));
                        }
                    });
                    animatorSet.setDuration(180);
                    animatorSet.start();
                    isShowView1 = true;
                    isEmpty = false;
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
                    ValueAnimator animatorRGBR7 = ValueAnimator.ofInt(0xcc464b56, 0xcc474954, 0xcc434552, 0xcc3E424F, 0xcc3A3E4D, 0xcc363a4b);
                    animatorRGBR7.setEvaluator(new ArgbEvaluator());
                    animatorRGBR7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int color = (int) animation.getAnimatedValue();
                            view1.setBackgroundColor(color);
                        }
                    });
                    ValueAnimator animatorRGBR8 = ValueAnimator.ofInt(0x7F808080, 0xcc757678, 0xcc6B6C6F, 0xcc606167, 0xcc56575E, 0xcc464b56);
                    animatorRGBR8.setEvaluator(new ArgbEvaluator());
                    animatorRGBR8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int color = (int) animation.getAnimatedValue();
                            view2.setBackgroundColor(color);
                        }
                    });


                    animatorSet.playTogether(animatorViewR1, animatorViewR2, animatorViewR3, animatorViewR4, animatorViewR5, animatorViewR6, animatorRGBR7, animatorRGBR8);
                    animatorSet.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            view3.setVisibility(View.VISIBLE);
                            view3.setAlpha(0.0f);

                            arrow.setVisibility(View.VISIBLE);
                            arrow.setAlpha(0.0f);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            List<String> data3 = new ArrayList<>();
                            for (int i = 0; i < BIAOQING.length; i++) {
                                data3.add(BIAOQING[i]);
                            }
                            LayoutAnimationController animation1 = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_animation_slide_left_view3);
                            view3.setLayoutAnimation(animation1);
                            view3.setAdapter(new ChannelAdapter(data3));
                        }
                    });
                    animatorSet.setDuration(200);
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


        if (isEmpty) {
            finish();
            return;
        }

        AnimatorSet animatorSet = new AnimatorSet();

        if (isShowView3) {
            ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", -260f, -1160f);
            ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", -260f, -1160f);
            ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", -260f, -1160f);
            ObjectAnimator animatorView4 = ObjectAnimator.ofFloat(arrow, "translationX", -260f, -1160f);
            ObjectAnimator animatorView5 = ObjectAnimator.ofFloat(view3, "alpha", 1.0f, 0.0f);


            animatorSet.playTogether(animatorView1, animatorView2, animatorView3, animatorView4, animatorView5);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view1.setAdapter(null);
                    view2.setAdapter(null);
                    view3.setAdapter(null);
                    view1.setTranslationX(-820);
                    view2.setTranslationX(-820);
                    view3.setTranslationX(-820);
                    view3.setVisibility(View.GONE);
                    arrow.setVisibility(View.INVISIBLE);

                }
            });
            animatorSet.setDuration(180);
            animatorSet.start();
            isShowView3 = false;
            isEmpty = true;
            return;
        }


        ObjectAnimator animatorView1 = ObjectAnimator.ofFloat(view1, "translationX", 0f, -820f);
        ObjectAnimator animatorView2 = ObjectAnimator.ofFloat(view2, "translationX", 0f, -820f);
        ObjectAnimator animatorView3 = ObjectAnimator.ofFloat(view3, "translationX", 0f, -820f);
        animatorSet.playTogether(animatorView1, animatorView2, animatorView3);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view1.setAdapter(null);
                view2.setAdapter(null);
                view3.setAdapter(null);
            }
        });
        animatorSet.setDuration(180);
        animatorSet.start();
        isShowView1 = false;
        isEmpty = true;


    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, ChannelActivity.class);
        ctx.startActivity(intent);
    }
}
