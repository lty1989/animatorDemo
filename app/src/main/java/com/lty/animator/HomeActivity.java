package com.lty.animator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lty.animator.home.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");

        mRecyclerView.setAdapter(new HomeAdapter(data));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    public static void start(Context ctx) {
        Intent intent = new Intent(ctx, HomeActivity.class);
        ctx.startActivity(intent);
    }
}
