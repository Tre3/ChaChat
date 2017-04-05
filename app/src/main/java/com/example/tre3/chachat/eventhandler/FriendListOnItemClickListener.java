package com.example.tre3.chachat.eventhandler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.tre3.chachat.view.activity.ChatActivity;

/**
 * Created by Tre3 on 2017/03/26.
 */

public class FriendListOnItemClickListener implements AdapterView.OnItemClickListener{
    private Context context;

    public FriendListOnItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = ChatActivity.createIntent(context);
        context.startActivity(intent);
    }
}
