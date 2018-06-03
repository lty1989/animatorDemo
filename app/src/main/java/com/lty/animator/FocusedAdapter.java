package com.lty.animator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andy on 2018/6/2.
 * Version : 1.0
 * Description :
 */
public class FocusedAdapter extends RecyclerView.Adapter<FocusedAdapter.ViewHolder> {


    private OnItenFocusedListener mOnItenFocusedListener;

    public void setOnItenFocusedListener(OnItenFocusedListener listener) {
        this.mOnItenFocusedListener = listener;
    }

    List<String> mData;


    public FocusedAdapter(List<String> mData) {
        this.mData = mData;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Button textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (Button) itemView;
        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Button textView = new Button(parent.getContext());
        textView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(mData.get(position));
        if (mOnItenFocusedListener != null) {
            holder.textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mOnItenFocusedListener.OnItemFocused(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
