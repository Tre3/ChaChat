package com.example.tre3.chachat.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FriendList{

    private FirebaseDatabaseCallback callback;

    public FriendList(FirebaseDatabaseCallback callback, String userId) {
        this.callback = callback;

        init(userId);
    }

    private void init(String userId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference();

        if (rootRef.child("friend_list") == null) {
            return;
        }

        if (rootRef.child("friend_list").child(userId) == null) {
            return;
        }

        DatabaseReference friendListDBRef = rootRef.child("friend_list").child(userId);
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
                    String friendName = (String) snapShot.child("friend_user_name").getValue();
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
