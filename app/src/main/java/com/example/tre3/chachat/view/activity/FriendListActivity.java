package com.example.tre3.chachat.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tre3.chachat.R;
import com.example.tre3.chachat.adapter.FriendListAdapter;
import com.example.tre3.chachat.adapter.factory.FriendListAdapterFactory;
import com.example.tre3.chachat.eventhandler.FriendListOnItemClickListener;
import com.example.tre3.chachat.model.FirebaseDatabaseCallback;
import com.example.tre3.chachat.model.FriendList;

import java.util.ArrayList;
import java.util.List;

public class FriendListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        initFriendList();
    }

    private void initFriendList() {
        FriendListAdapter friendListAdapter = FriendListAdapterFactory.createFriendListAdapter(this);

        ListView listView = (ListView) findViewById(R.id.activity_friend_list);
        listView.setAdapter(friendListAdapter);

        FriendListOnItemClickListener listOnItemClickListener = new FriendListOnItemClickListener(this);
        listView.setOnItemClickListener(listOnItemClickListener);
    }
}
