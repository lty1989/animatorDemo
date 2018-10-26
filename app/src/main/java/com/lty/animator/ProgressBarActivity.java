package com.lty.animator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

import butterknife.BindView;

public class ProgressBarActivity extends BaseActivity {

    @BindView(R.id.progressBar)
    SeekBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressBar.setSecondaryProgress(80);
        mProgressBar.setProgress(70);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress_bar;
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, ProgressBarActivity.class);
        ctx.startActivity(intent);
    }
}
