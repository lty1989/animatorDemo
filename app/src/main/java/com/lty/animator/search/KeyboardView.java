package com.lty.animator.search;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class KeyboardView extends LinearLayout {


    private String[] mContents = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private final int LINE = 6;

    public KeyboardView(Context context) {
        super(context);
        init();
    }

    public KeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            data.add(String.valueOf(c));
        }

        for (int i = 0; i < mContents.length; i++) {
            data.add(mContents[i]);
        }

        for (int i = 0; i < LINE; i++) {
            addLine(data.subList(i * LINE, (i + 1) * LINE));
        }


    }


    private void addLine(List<String> keys) {
        Log.d("KeyboardView", keys.toString());
        LinearLayout lineLayout = new LinearLayout(getContext());
        lineLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        lineLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);

        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(100, 100);
        paramsLeft.leftMargin = 10;
        for (int i = 0; i < keys.size(); i++) {
            Button keyBtn = new Button(getContext());
            keyBtn.setText(keys.get(i));
            keyBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            if (i == 0) {
                keyBtn.setLayoutParams(params);
            } else {
                keyBtn.setLayoutParams(paramsLeft);
            }
            lineLayout.addView(keyBtn);
        }
        addView(lineLayout);
    }
}
