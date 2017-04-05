package com.example.tre3.chachat.adapter.factory;

import android.content.Context;

import com.example.tre3.chachat.adapter.ChatAdapter;
import com.example.tre3.chachat.adapter.FriendListAdapter;
import com.example.tre3.chachat.model.Chats;
import com.example.tre3.chachat.model.FirebaseDatabaseCallback;
import com.example.tre3.chachat.model.FriendList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tre3 on 2017/03/26.
 */

public class ChatAdapterFactory {

    public static ChatAdapter createChatAdapter(Context context) {
        List<String> message = new ArrayList<>();
        ChatAdapter chatAdapter = new ChatAdapter(context, 0, message);
        Chats chats = new Chats(createCallback(chatAdapter), "dummy");

        return chatAdapter;
    }

    private static FirebaseDatabaseCallback createCallback(final ChatAdapter chatAdapter) {
        return new FirebaseDatabaseCallback() {
            @Override
            public void notifyFriendListUpdate(List<String> friendList) {
                if ((chatAdapter == null) || (chatAdapter.getItems() == null)) {
                    return;
                }

                chatAdapter.getItems().clear();
                chatAdapter.getItems().addAll(friendList);
                chatAdapter.notifyDataSetChanged();
            }
        };
    }
}
