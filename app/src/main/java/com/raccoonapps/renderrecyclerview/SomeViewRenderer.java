package com.raccoonapps.renderrecyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class SomeViewRenderer extends ViewRenderer<SomeModel, SomeViewHolder> {


    public SomeViewRenderer(int viewType, @NonNull Context context) {
        super(viewType, context);
    }

    @Override
    public void bindView(@NonNull SomeModel model, @NonNull SomeViewHolder holder) {
        holder.mTitle.setText(model.getTitle());
    }

    @NonNull
    @Override
    public SomeViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return new SomeViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false));
    }
}
