package com.raccoonapps.renderrecyclerview;


import android.support.annotation.NonNull;

public class SomeModel implements ItemModel {

    public static final int TYPE = 0;
    private final String mTitle;

    public SomeModel(@NonNull final String title) {
        mTitle = title;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }
}
