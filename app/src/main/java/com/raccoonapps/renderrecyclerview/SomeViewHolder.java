package com.raccoonapps.renderrecyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SomeViewHolder extends RecyclerView.ViewHolder {

    public TextView mTitle;

    public SomeViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.title);
    }
}
