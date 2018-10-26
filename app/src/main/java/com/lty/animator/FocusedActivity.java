package com.lty.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FocusedActivity extends BaseActivity {

    @BindView(R.id.view1)
    TTRecyclerView view1;

    @BindView(R.id.view2)
    TTRecyclerView view2;

    @BindView(R.id.view3)
    TTRecyclerView view3;

    @BindView(R.id.focused)
    Button focused;

    FocusedView mFocusedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFocusedView = new FocusedView(this);
        mFocusedView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        mFocusedView.bindActivity(this);


        view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            data.add("abc" + i);
        }


        FocusedAdapter focusedAdapter = new FocusedAdapter(data);
//        focusedAdapter.setOnItenFocusedListener(new OnItenFocusedListener() {
//            @Override
//            public void OnItemFocused(View view, int poistion) {
//                Log.d("FocusedActivity", "left-->" + view.getLeft() + ",top-->" + view.getTop() + ",right-->" + view.getRight() + ",bottom-->" + view.getBottom());
//
//                focused.setVisibility(View.VISIBLE);
//                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) focused.getLayoutParams();
//                lp.topMargin = view.getTop();
//                lp.width = view.getRight() - view.getLeft();
//                lp.height = view.getBottom() - view.getTop();
////                focused.setTop(view.getTop());
////                focused.setLeft(view.getLeft());
////                focused.setBottom(view.getBottom());
////                focused.setRight(view.getRight());
//            }
//        });


        view1.setAdapter(focusedAdapter);
        view2.setAdapter(focusedAdapter);
        view3.setAdapter(focusedAdapter);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_focused;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:


                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, FocusedActivity.class);
        ctx.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        mFocusedView.destory();
        super.onDestroy();
    }
}
