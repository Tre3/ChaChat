package com.example.tre3.chachat.presenter;

import com.example.tre3.chachat.contract.ChatContracts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Tre3 on 2017/04/06.
 */

public class ChatPresenter implements ChatContracts {
    private DatabaseReference mChatDBRef;

    public ChatPresenter(String roomId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference();

        if (rootRef.child("chats") == null) {
            return;
        }

        if (rootRef.child("chats").child(roomId) == null) {
            return;
        }

        mChatDBRef = rootRef.child("chats").child(roomId);
    }

    @Override
    public void sendMessage(String message) {
        if (mChatDBRef == null) {
            return;
        }

        mChatDBRef.push().setValue(new Message(message, "dummy"));
    }

    public static class Message {
        public String message;
        public String userId;

        public Message(String message, String userId) {
            this.message = message;
            this.userId = userId;
        }
    }
}
