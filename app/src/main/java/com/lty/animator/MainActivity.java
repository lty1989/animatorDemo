package com.lty.animator;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;

import com.lty.animator.live.LiveActivity;
import com.lty.animator.util.DeviceUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btnShake)
    Button shakeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        long totalInternalMemorySize = DeviceUtil.getTotalInternalMemorySize();
        long availableInternalMemorySize = DeviceUtil.getAvailableInternalMemorySize();
        Log.d("MainActivity", "--->" + totalInternalMemorySize + "," + availableInternalMemorySize);
        Log.d("MainActivity", "--->" + DeviceUtil.formatFileSize(this, totalInternalMemorySize) + "," + DeviceUtil.formatFileSize(this, availableInternalMemorySize));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btnLive)
    public void live() {
        LiveActivity.start(this);
    }


    @OnClick(R.id.btnShake)
    public void shake() {
        ShakeActivity.start(this);
    }

    @OnClick(R.id.btnHome)
    public void home() {
        HomeActivity.start(this);
    }


    @OnClick(R.id.btnSearch)
    public void search() {
        SearchActivity.start(this);
    }

    @OnClick(R.id.btnChannel)
    public void channel() {
        ChannelActivity.start(this);
    }

    @OnClick(R.id.btnFocused)
    public void focused() {
        FocusedActivity.start(this);
    }

    @OnClick(R.id.btnConstraint)
    public void constraint() {
        ConstraintActivity.start(this);
    }

    @OnClick(R.id.btnFront)
    public void front() {
        FontActivity.start(this);
    }

    @OnClick(R.id.btnProgress)
    public void progress() {
        ProgressBarActivity.start(this);
    }


    public static String getDiskCachePath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }
}
