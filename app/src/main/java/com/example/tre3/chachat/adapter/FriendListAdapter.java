package com.example.tre3.chachat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.tre3.chachat.view.customview.FriendCell;

import java.util.List;

public class FriendListAdapter extends ArrayAdapter<String>{
    private List<String> friendList;

    public FriendListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);

        friendList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String text = getItem(position);
        FriendCell friendCell = new FriendCell(getContext());
        friendCell.setText(text);

        return friendCell;
    }

    public List<String> getItems() {
        return friendList;
    }
}
