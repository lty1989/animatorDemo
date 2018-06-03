package com.lty.animator;

import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


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

    @OnClick(R.id.btnChannel)
    public void channel() {
        ChannelActivity.start(this);
    }

    @OnClick(R.id.btnFocused)
    public void focused() {
        FocusedActivity.start(this);
    }
}
