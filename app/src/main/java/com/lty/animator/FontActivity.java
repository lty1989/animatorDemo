package com.lty.animator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class FontActivity extends BaseActivity {

    @BindView(R.id.sc_tv)
    TextView scTv;

    @BindView(R.id.rb_tv)
    TextView rbTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SCBold.otf");
        if (typeface != null) {
            scTv.setTypeface(typeface);
            scTv.setText("思源 看效果 123");
        }



        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Rb.ttf");
        if (typeface1 != null) {
            rbTv.setTypeface(typeface1);
            rbTv.setText("Roboto ABCD 1234");
        }
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_font;


    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, FontActivity.class);
        ctx.startActivity(intent);
    }
}
