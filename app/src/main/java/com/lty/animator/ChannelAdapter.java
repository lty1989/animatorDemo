package com.lty.animator;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by andy on 2018/6/2.
 * Version : 1.0
 * Description :
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {


    List<String> mData;


    public ChannelAdapter(List<String> mData) {
        this.mData = mData;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 110));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 38);
        textView.setTextColor(Color.parseColor("#ccEBEBEB"));
        textView.setGravity(Gravity.CENTER_VERTICAL);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
