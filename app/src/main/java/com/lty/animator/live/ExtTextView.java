package com.lty.animator.live;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class ExtTextView extends TextView {


    public ExtTextView(Context context) {
        super(context);
    }

    public ExtTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setWidth(int width) {
        getLayoutParams().width = width;
        requestLayout();
    }
}
