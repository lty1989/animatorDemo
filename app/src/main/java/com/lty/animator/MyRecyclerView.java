package com.lty.animator;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by andyliu on 2018/6/6.
 */

public class MyRecyclerView extends RecyclerView implements View.OnFocusChangeListener {

    private int mSelectedPosition = 0;


    public MyRecyclerView(Context context) {
        super(context);
        init();

    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init() {
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setHasFixedSize(true);
        setOverScrollMode(View.OVER_SCROLL_NEVER);

        setClipChildren(false);
        setClipToPadding(false);

        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        setFocusable(true);
        setFocusableInTouchMode(true);

    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (null != view && view != this) {
            final int position = getChildAdapterPosition(view);
            Log.d("MyRecyclerView", "position:" + position);
            view.setSelected(hasFocus);
        }

    }

    public void setSelection(int position) {
        if (null == getAdapter() || position < 0 || position >= getItemCount()) {
            return;
        }

        View view = getChildAt(position - getFirstVisiblePosition());
        if (null != view) {
            if (!hasFocus()) {
                //模拟TvRecyclerView获取焦点
                onFocusChanged(true, FOCUS_DOWN, null);
            }
            view.requestFocus();
        }

    }

    public void requestDefaultFocus() {
        setSelection(mSelectedPosition);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (null == getFocusedChild()) {
            //请求默认焦点
            requestDefaultFocus();
        }
        return false;
    }

    public int getFirstVisiblePosition() {
        if (getChildCount() == 0)
            return 0;
        else
            return getChildAdapterPosition(getChildAt(0));
    }

    public int getItemCount() {
        if (null != getAdapter()) {
            return getAdapter().getItemCount();
        }
        return 0;
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        if (gainFocus) {
            setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        } else {
            setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void onChildAttachedToWindow(View child) {

        if (child.isFocusable() && null == child.getOnFocusChangeListener()) {
            child.setOnFocusChangeListener(this);
        }
    }
}
