package com.lty.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

public class FocusedView extends View implements ViewTreeObserver.OnGlobalFocusChangeListener {


    private TranslateRect mTranslateRect;

    private AnimatorSet mTranslateAnimatorSet;

    private TranslateListener mTranslateListener;

    private boolean isShow;


    public FocusedView(Context context) {
        super(context);
        init();
    }

    public FocusedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FocusedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        registerListener();
        mTranslateRect = new TranslateRect();
        mTranslateListener = new TranslateListener();
        setBackgroundColor(Color.BLUE);
    }


    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {

//        if (newFocus != null) {
//            if (!isShow) {
//                Rect rect = new Rect();
//                newFocus.getGlobalVisibleRect(rect);
//                Log.d("FocusedView", "left-->" + rect.left + ",top-->" + rect.top + ",right-->" + rect.right + ",bottom-->" + rect.right);
//                setVisibility(View.VISIBLE);
//                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) getLayoutParams();
//                lp.topMargin = rect.top;
//                lp.leftMargin = rect.left;
//                lp.width = rect.width();
//                lp.height = rect.height();
//                setBackgroundColor(Color.BLUE);
//                isShow = true;
//            }
//        }

        Rect start = new Rect();
        if (oldFocus == null) {
            this.getGlobalVisibleRect(start);
        } else {
            oldFocus.getGlobalVisibleRect(start);
        }

        Log.d("FocusedView", "left-->" + start.left + ",top-->" + start.top + ",right-->" + start.right + ",bottom-->" + start.right);


        if (newFocus != null) {
            Rect end = new Rect();
            newFocus.getGlobalVisibleRect(end);


            translateFocusEffect(start, end, 200);

        }
    }

    public void bindActivity(Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this);
    }

    /**
     * 注册监听事件
     */
    public void registerListener() {
        this.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    /**
     * 取消监听事件
     */
    public void unRegisterListener() {
        this.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);

    }

    public void destory() {
        unRegisterListener();
        mTranslateListener = null;
        mTranslateRect = null;
        releaseTranslateAnim();
    }


    private class TranslateRect {

        private int left;

        private int top;

        private int right;

        private int bottom;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
            FocusedView.this.setLeft(left);
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
            FocusedView.this.setTop(top);
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
            FocusedView.this.setRight(right);
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
            FocusedView.this.setBottom(bottom);
        }
    }


    protected void translateFocusEffect(Rect startRect, Rect endRect, long duration) {

        releaseTranslateAnim();

        if (startRect.equals(endRect)) return;

        ValueAnimator animLeft = ObjectAnimator.ofInt(mTranslateRect, "left", startRect.left, endRect.left);
        ValueAnimator animTop = ObjectAnimator.ofInt(mTranslateRect, "top", startRect.top, endRect.top);
        ValueAnimator animRight = ObjectAnimator.ofInt(mTranslateRect, "right", startRect.right, endRect.right);
        ValueAnimator animBottom = ObjectAnimator.ofInt(mTranslateRect, "bottom", startRect.bottom, endRect.bottom);

        mTranslateAnimatorSet = new AnimatorSet();
        mTranslateAnimatorSet.setDuration(duration);
        //mTranslateAnimatorSet.addListener(mTranslateListener);
        mTranslateAnimatorSet.setInterpolator(new DecelerateInterpolator());
        mTranslateAnimatorSet.playTogether(animLeft, animTop, animRight, animBottom);
        mTranslateAnimatorSet.start();
    }

    protected void releaseTranslateAnim() {
        if (mTranslateAnimatorSet != null) {
            mTranslateAnimatorSet.end();
            mTranslateAnimatorSet.cancel();
            mTranslateAnimatorSet = null;
        }
    }

    private class TranslateListener implements Animator.AnimatorListener {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            releaseTranslateAnim();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

}
