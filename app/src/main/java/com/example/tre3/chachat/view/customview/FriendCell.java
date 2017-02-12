package com.example.tre3.chachat.view.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tre3.chachat.R;

public class FriendCell extends LinearLayout {
    private TextView mTextView;

    public FriendCell(Context context) {
        super(context);
        init();
    }

    public FriendCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public FriendCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_friend_cell, this);
        mTextView = (TextView) findViewById(R.id.friend_cell_text);
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}
