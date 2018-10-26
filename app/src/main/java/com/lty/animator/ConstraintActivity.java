package com.lty.animator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ConstraintActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_constraint;
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, ConstraintActivity.class);
        ctx.startActivity(intent);
    }
}
