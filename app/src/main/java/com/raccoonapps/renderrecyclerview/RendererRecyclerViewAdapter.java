package com.raccoonapps.renderrecyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RendererRecyclerViewAdapter extends RecyclerView.Adapter {

    @NonNull
    private final ArrayList<ItemModel> mItems = new ArrayList<>();

    @NonNull
    private final SparseArray<ViewRenderer> mRenderers = new SparseArray<>();

    private ViewRenderer mRenderer;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewRenderer renderer = mRenderers.get(viewType);
        if (renderer != null) {
            return renderer.createViewHolder(parent);
        }
        throw new RuntimeException("Not supported Item View Type: " + viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ItemModel item = getItem(position);

        final ViewRenderer renderer = mRenderers.get(item.getType());
        if (renderer != null) {
            renderer.bindView(item, holder);
        } else {
            throw new RuntimeException("Not supported View Holder: " + holder);
        }
    }

    @Override
    public int getItemViewType(final int position) {
        final ItemModel item = getItem(position);
        return item.getType();
    }

    private ItemModel getItem(final int position) {
        return mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(@NonNull final ArrayList<ItemModel> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    public void registerRenderer(@NonNull final ViewRenderer renderer) {
        final int type = renderer.getType();
        if (mRenderers.get(type) == null) {
            mRenderers.put(type, renderer);
        } else {
            throw new RuntimeException("ViewRenderer already exist with this type: " + type);
        }
    }
}
