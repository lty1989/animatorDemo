package com.lty.animator;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btnShake)
    Button shakeBtn;

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
}
