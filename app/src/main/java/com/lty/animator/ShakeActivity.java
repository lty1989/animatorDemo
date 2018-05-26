package com.lty.animator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class ShakeActivity extends BaseActivity {


    @BindView(R.id.container)
    RelativeLayout containerLl;

    @BindView(R.id.btnShake)
    Button shakeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_shake;
    }


    @OnClick(R.id.btnShake)
    public void shake() {
        final TrembleAni tremble = new TrembleAni();
        tremble.setDuration(50);// 持续时间800ms，持续时间越短频率越高
        // tremble.setRepeatCount(1);// 重复次数，不包含第一次
        containerLl.startAnimation(tremble);
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, ShakeActivity.class);
        ctx.startActivity(intent);
    }
}
