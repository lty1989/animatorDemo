package com.lty.animator.live;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lty.animator.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {

    private List<String> data;


    public LiveAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_live_left, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.show();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iconTv)
        ImageView mIconIv;
        @BindView(R.id.contentTv)
        ExtTextView mContentTv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void show() {


            PropertyValuesHolder pvhX = PropertyValuesHolder.ofInt("width", 0, 150);
            PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);

            ObjectAnimator.ofPropertyValuesHolder(mContentTv, pvhX, pvhY).setDuration(400).start();


        }

        public void hide() {
            ObjectAnimator.ofFloat(mContentTv, "translationX", 70f, 0f).setDuration(400).start();
        }

    }
}
