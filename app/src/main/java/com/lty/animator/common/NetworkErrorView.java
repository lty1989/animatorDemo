package com.lty.animator.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lty.animator.R;

public class NetworkErrorView extends RelativeLayout {


    private ImageView mErrorIv;
    private Button mFunction1Btn;
    private Button mFunction2Btn;

    private int mErrorIvId = 0x0001;
    private int mFunction1BtnId = 0x0002;
    private int mFunction2BtnId = 0x0003;

    private int mErrorImage;
    private String mErrFun1;
    private String mErrFun2;


    public NetworkErrorView(Context context) {
        super(context);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.NetworkErrorView);
        mErrorImage = array.getResourceId(R.styleable.NetworkErrorView_error_icon, -1);
        mErrFun1 = array.getString(R.styleable.NetworkErrorView_error_fun1);
        mErrFun2 = array.getString(R.styleable.NetworkErrorView_error_fun2);
        array.recycle();
        init();
    }

    private void init() {
        addErrorImage();
        addErrorFun();
    }

    private void addErrorImage() {
        mErrorIv = new ImageView(getContext());
        mErrorIv.setId(mErrorIvId);
        RelativeLayout.LayoutParams errorImage_params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        errorImage_params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mErrorIv.setLayoutParams(errorImage_params);
        addView(mErrorIv);
        mErrorIv.setImageResource(mErrorImage);

    }


    private void addErrorFun() {
        mFunction1Btn = new Button(getContext());
        mFunction1Btn.setId(mFunction1BtnId);
        RelativeLayout.LayoutParams errorFun1_params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        errorFun1_params.topMargin = 108;
        errorFun1_params.addRule(RelativeLayout.BELOW, mErrorIvId);
        if (TextUtils.isEmpty(mErrFun2)) {
            errorFun1_params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        } else {
            errorFun1_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        }
        mFunction1Btn.setLayoutParams(errorFun1_params);
        addView(mFunction1Btn);
        mFunction1Btn.setText(mErrFun1);


        if (!TextUtils.isEmpty(mErrFun2)) {
            mFunction2Btn = new Button(getContext());
            mFunction2Btn.setId(mFunction2BtnId);
            RelativeLayout.LayoutParams errorFun2_params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            errorFun2_params.topMargin = 108;
            errorFun2_params.addRule(RelativeLayout.BELOW, mErrorIvId);
            errorFun2_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            mFunction2Btn.setLayoutParams(errorFun2_params);
            mFunction2Btn.setText(mErrFun2);
            addView(mFunction2Btn);
        }

    }

}
