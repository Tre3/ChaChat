package com.example.tre3.chachat.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tre3 on 2017/03/26.
 */

public class Chats {

    private FirebaseDatabaseCallback callback;

    public Chats(FirebaseDatabaseCallback callback, String roomId) {
        this.callback = callback;

        init(roomId);
    }

    private void init(String roomId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference();

        if (rootRef.child("chats") == null) {
            return;
        }

        if (rootRef.child("chats").child(roomId) == null) {
            return;
        }

        DatabaseReference friendListDBRef = rootRef.child("chats").child(roomId);
        friendListDBRef.addValueEventListener(createEventListener());
    }

    private ValueEventListener createEventListener() {

        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (callback == null) {
                    return;
                }

                List<String> friends = new ArrayList<>();

                for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
                    String friendName = (String) snapShot.child("message").getValue();
                    friends.add(friendName);
                }

                callback.notifyFriendListUpdate(friends);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }
}
