package com.lty.animator;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btnShake)
    Button shakeBtn;

    @BindView(R.id.btnSlide)
    Button slideBtn;

    @BindView(R.id.btnTVSlide)
    Button tvSlideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btnShake)
    public void shake() {
        ShakeActivity.start(this);
    }

    @OnClick(R.id.btnSlide)
    public void slide() {
        SlideActivity.start(this);
    }

    @OnClick(R.id.btnTVSlide)
    public void tvSlide() {
        TVSlideActivity.start(this);
    }
}
