package com.raccoonapps.renderrecyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class ViewRenderer <M extends ItemModel, VH extends RecyclerView.ViewHolder> {


    private final int mViewType;
    @NonNull
    private final Context mContext;

    @NonNull
    public Context getContext() {
        return mContext;
    }

    public
    ViewRenderer(final int viewType, @NonNull final Context context) {
        mViewType = viewType;
        mContext = context;
    }

    public abstract void bindView(@NonNull M model, @NonNull VH holder);

    @NonNull
    public abstract VH createViewHolder(@Nullable ViewGroup parent);

    public int getType() {
        return mViewType;
    }

}
