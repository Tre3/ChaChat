package com.example.tre3.chachat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.tre3.chachat.view.customview.ChatCell;
import com.example.tre3.chachat.view.customview.FriendCell;

import java.util.List;

/**
 * Created by Tre3 on 2017/03/26.
 */

public class ChatAdapter extends ArrayAdapter<String> {
    private List<String> messages;

    public ChatAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);

        messages = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String text = getItem(position);
        ChatCell chatCell = new ChatCell(getContext());
        chatCell.setText(text);

        return chatCell;
    }

    public List<String> getItems() {
        return messages;
    }
}
