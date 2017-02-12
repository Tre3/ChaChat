package com.example.tre3.chachat.adapter.factory;

import android.content.Context;

import com.example.tre3.chachat.adapter.FriendListAdapter;
import com.example.tre3.chachat.model.FirebaseDatabaseCallback;
import com.example.tre3.chachat.model.FriendList;

import java.util.ArrayList;
import java.util.List;

public class FriendListAdapterFactory {

    public static FriendListAdapter createFriendListAdapter(Context context) {
        List<String> friendList = new ArrayList<>();
        FriendListAdapter friendListAdapter = new FriendListAdapter(context, 0, friendList);
        FriendList friends = new FriendList(createCallback(friendListAdapter), "dummy");

        return friendListAdapter;
    }

    private static FirebaseDatabaseCallback createCallback(final FriendListAdapter friendListAdapter) {
        return new FirebaseDatabaseCallback() {
            @Override
            public void notifyFriendListUpdate(List<String> friendList) {
                if ((friendListAdapter == null) || (friendListAdapter.getItems() == null)) {
                    return;
                }

                friendListAdapter.getItems().clear();
                friendListAdapter.getItems().addAll(friendList);
                friendListAdapter.notifyDataSetChanged();
            }
        };
    }
}
